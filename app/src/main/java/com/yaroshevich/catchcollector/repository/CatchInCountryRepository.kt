package com.yaroshevich.catchcollector.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.yaroshevich.catchcollector.App
import com.yaroshevich.catchcollector.model.CatchInCountry
import com.yaroshevich.catchcollector.model.Fish
import com.yaroshevich.catchcollector.model.Trophy
import com.yaroshevich.catchcollector.room.entities.FishEntity

class CatchInCountryRepository {


    var list = MutableLiveData<CatchInCountry>()

    val database = App.getInstance().database

    val fishDao = database.fishDao()

    val fishCountryDao = database.fishCountryDao()


    suspend fun getAllById(id: Int): List<Fish> {
        val counries = fishCountryDao.getAllById(id)
        Log.e("nf", " msg ${counries?.size}")
        val fishes = mutableListOf<FishEntity>()

        val fishList = mutableListOf<Fish>()
        counries?.forEach {
            var fish = fishDao.getById(it.fishId)!!
            var trophy = database.trophyDao().getBest(it.id)


            fishList.add(
                Fish(
                    name = fish.name,
                    bestTrophy = if (trophy != null) {
                        Trophy(trophy!!.id, trophy.length, trophy.weight, trophy.fishId)
                    } else null
                )
            )
        }

        return fishList

    }

    suspend fun getBestTrophyBy(fishId: Int): Trophy? {
        val result = database.trophyDao().getBest(fishId)
        if (result != null) {
            val trophy = Trophy(
                id = result.id,
                length = result.length,
                weight = result.weight,
                fishId = result.fishId
            )
            return trophy
        }


        return null

    }
}