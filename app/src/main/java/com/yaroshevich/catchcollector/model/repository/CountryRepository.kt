package com.yaroshevich.catchcollector.model.repository

import android.util.Log
import com.yaroshevich.catchcollector.App
import com.yaroshevich.catchcollector.model.Country
import com.yaroshevich.catchcollector.model.room.entities.CountryEntity

class CountryRepository {

    private val countryDao = App.getInstance().database.countryDao()

    suspend fun getAll(): List<Country> {
        val countryEntityList = countryDao.getAll()
        val countryModelList = mutableListOf<Country>()

        countryEntityList.forEach {
            var country = Country(id = it.id, name = it.name, iconPath = it.iconName)
            countryModelList.add(country)
        }

        return countryModelList
    }


    suspend fun getBy(id: Int): Country? {
        val country = countryDao.getById(id)

        return when (country) {
            null -> null
            else -> map(country)
        }

    }

    suspend fun search(request: String): List<Country> {

        val requestResult = countryDao.search(request)
        requestResult.forEach {
            Log.e("Result", "${it.id} + ${it.name}")
        }
        return map(requestResult)
    }


    private fun map(entity: CountryEntity): Country {

        return Country(id = entity.id, name = entity.name, iconPath = entity.iconName)

    }

    fun map(entities: List<CountryEntity>): List<Country> {

        val result = mutableListOf<Country>()

        entities.forEach {

            result.add(map(it))

            Log.e("ResultCountry", "${it.id} + ${it.name}")

        }

        return result
    }
}