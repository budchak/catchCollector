package com.yaroshevich.catchcollector.model.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.yaroshevich.catchcollector.App
import com.yaroshevich.catchcollector.model.FishListInCountry
import com.yaroshevich.catchcollector.model.Fish
import com.yaroshevich.catchcollector.model.Trophy
import com.yaroshevich.catchcollector.model.room.entities.FishEntity

class CatchInCountryRepository {


    var list = MutableLiveData<FishListInCountry>()

    val database = App.getInstance().database

    val fishDao = database.fishDao()

    val fishCountryDao = database.fishCountryDao()


    suspend fun getAllById(id: Int): List<Fish> {
        val countries = fishCountryDao.getAllById(id)
        Log.e("nf", " msg ${countries?.size}")
        val fishes = mutableListOf<FishEntity>()

        val fishList = mutableListOf<Fish>()
        countries?.forEach {
            val fish = fishDao.getById(it.fishId)!!
            val trophy = database.trophyDao().getBest(it.id)


            fishList.add(
                Fish(
                    name = fish.name,
                    bestTrophy = if (trophy != null) {
                        Trophy(trophy.id, trophy.length, trophy.weight, trophy.fishId)
                    } else null
                )
            )
        }

        return fishList

    }

    suspend fun getBestTrophyBy(fishId: Int): Trophy? {
        val result = database.trophyDao().getBest(fishId)
        if (result != null) {
            return Trophy(
                id = result.id,
                length = result.length,
                weight = result.weight,
                fishId = result.fishId,
                imagePath = null
            )
        }


        return null

    }
}