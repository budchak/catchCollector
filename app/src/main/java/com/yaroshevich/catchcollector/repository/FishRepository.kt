package com.yaroshevich.catchcollector.repository

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