package com.yaroshevich.catchcollector.model.room.dao

import androidx.room.*
import com.yaroshevich.catchcollector.model.room.entities.CountryEntity
import com.yaroshevich.catchcollector.model.room.entities.TrophyImagePathEntity

@Dao
interface TrophyImagePathDao {



    @Query("SELECT * FROM trophy_image_path")
    suspend fun getAll(): List<TrophyImagePathEntity>

    @Query("SELECT * FROM trophy_image_path WHERE id = :trophyId")
    suspend fun getById(trophyId: Int): TrophyImagePathEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(trophyImagePathEntity: CountryEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(trophyImagePathEntity: List<TrophyImagePathEntity>)

    @Update
    fun update(trophyImagePathEntity: TrophyImagePathEntity)

    @Delete
    fun delete(trophyImagePathEntity: TrophyImagePathEntity)

}