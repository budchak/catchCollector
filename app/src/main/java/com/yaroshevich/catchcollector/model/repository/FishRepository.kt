package com.yaroshevich.catchcollector.model.repository

import com.yaroshevich.catchcollector.model.Fish


class FishRepository {

    private var fishList = mutableListOf<Fish>()


    init {
        fishList.add(
            Fish(
                id = 1,
                name = "Карп"
            )
        )
    }

    fun getAll() = fishList
}