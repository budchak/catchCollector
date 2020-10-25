package com.yaroshevich.catchcollector.model.room.dao

import android.util.Log
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.yaroshevich.catchcollector.model.Trophy
import com.yaroshevich.catchcollector.model.TrophyPreview
import com.yaroshevich.catchcollector.model.room.entities.FishEntity
import com.yaroshevich.catchcollector.model.room.entities.TrophyEntity
import com.yaroshevich.catchcollector.model.room.entities.TrophyImagePathEntity


@Dao
abstract class TrophyPreviewDao {


    @Query("SELECT * FROM fish WHERE sdb = :country_id")
    abstract suspend fun getAll(country_id: Int): List<FishEntity>

    @Query("SELECT * FROM trophy WHERE fishId = :fishId AND countryId = :countryId ORDER BY length DESC")
    abstract suspend fun getBest(fishId: Int, countryId: Int): TrophyEntity?

    @Query("SELECT * FROM trophy_image_path WHERE trophyId = :trophy_id")
    abstract suspend fun getTrophyImage(trophy_id: Int): TrophyImagePathEntity?

    @Transaction
    open suspend fun getPreview(country_id: Int): List<TrophyPreview> {
        val fishes = getAll(country_id)

        val preview = mutableListOf<TrophyPreview>()


        fishes.forEach {

            val previewItem = TrophyPreview(country_id, it.id, it.name, it.imagePath)
            val result = getBest(country_id, it.id)
            if (result != null) {
                val trophy = Trophy(
                    id = result.id,
                    length = result.length,
                    weight = result.weight,
                    fishId = result.fishId
                )
                previewItem.bestTrophy = trophy

                val trImage = getTrophyImage(trophy.id)?.imagePath
                if (trImage != null){
                    previewItem.previewImage = trImage
                    Log.e(this.javaClass.simpleName, "path: ${trophy.id} $trImage")
                }else{
                    Log.e(this.javaClass.simpleName, "path = null: ${trophy.id} $trImage")
                }


                preview.add(previewItem)
            } else {
                preview.add(previewItem)
            }


        }

        return preview
    }
}