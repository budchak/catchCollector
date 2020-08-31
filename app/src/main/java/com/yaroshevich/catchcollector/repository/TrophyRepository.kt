package com.yaroshevich.catchcollector.repository

import com.yaroshevich.catchcollector.App
import com.yaroshevich.catchcollector.model.Trophy

class TrophyRepository {

    val trophyDao = App.getInstance().database.trophyDao()

    suspend fun getAllBy(fishId: Int): List<Trophy> {
        val a = trophyDao.getBy(fishId)
        val list = mutableListOf<Trophy>()

        a?.forEach {
            val trophy =
                Trophy(id = it.id, length = it.length, weight = it.weight, fishId = it.fishId)
            list.add(trophy)
        }

        return list
    }


    suspend fun isContainTrophy(fishId: Int, countryId: Int): Boolean{

        return when(trophyDao.getBest(fishId, countryId)){
            null -> false
            else -> true
        }
    }

    suspend fun getBestTrophyBy(fishId: Int): Trophy? {
        val result = trophyDao.getBest(fishId)
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