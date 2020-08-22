package com.yaroshevich.catchcollector.repository

import com.yaroshevich.catchcollector.App
import com.yaroshevich.catchcollector.model.Country

class CountryRepository {


    suspend fun getAll(): List<Country> {
        val a = App.getInstance().database.countryDao().getAll()
        val list = mutableListOf<Country>()

        a.forEach {
            var country = Country(id = it.id,name = it.name, iconPath = it.iconName)
            list.add(country)
        }

        return list
    }

}