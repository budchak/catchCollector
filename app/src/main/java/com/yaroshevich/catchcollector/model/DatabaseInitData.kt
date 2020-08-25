package com.yaroshevich.catchcollector.model

import com.yaroshevich.catchcollector.room.TrophyDatabase
import com.yaroshevich.catchcollector.room.entities.CountryEntity
import com.yaroshevich.catchcollector.room.entities.FishCountryEntity
import com.yaroshevich.catchcollector.room.entities.FishEntity
import com.yaroshevich.catchcollector.room.entities.TrophyEntity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DatabaseInitData(val database: TrophyDatabase) {


    var countryList = mutableListOf<CountryEntity>()

    val fishList = mutableListOf<FishEntity>()

    val fishCountryList = mutableListOf<FishCountryEntity>()

    val trophyList = mutableListOf<TrophyEntity>()

    fun initData() {
        initCountryList()
        initFish()
        initFishCountry()
        initTrophy()
    }

    private fun initCountryList() {
        countryList.apply {
            add(
                CountryEntity(
                    id = 1,
                    name = "Беларусь",
                    iconName = "/images/country/title_country_belarus.png"
                )
            )
            add(
                CountryEntity(
                    id = 2,
                    name = "Россия",
                    iconName = "/images/country/title_country_russia.png"
                )
            )
            add(
                CountryEntity(
                    id = 3,
                    name = "Украина",
                    iconName = "/images/country/title_country_ukraine.png"
                )
            )
            add(
                CountryEntity(
                    id = 4,
                    name = "Польша",
                    iconName = "/images/country/title_country_belarus.png"
                )
            )
        }

        GlobalScope.launch {

            database.countryDao().insert(countryList)

        }

    }

    private fun initFish() {
        fishList.apply {
            add(FishEntity(1, "Карп", "1"))
            add(FishEntity(2, "Карась", "1"))
            add(FishEntity(3, "Карась серебрянный", "1"))
            add(FishEntity(4, "Плотва", "1"))
            add(FishEntity(5, "Налим", "1"))
            add(FishEntity(6, "Сельдь", "2"))
        }

        GlobalScope.launch {

            database.fishDao().insert(fishList)

        }
    }

    private fun initFishCountry() {
        fishCountryList.apply {
            add(FishCountryEntity(1, 1, 1))
            add(FishCountryEntity(1, 2, 2))
            add(FishCountryEntity(1, 3, 3))
            add(FishCountryEntity(1, 4, 4))
            add(FishCountryEntity(1, 5, 5))
            add(FishCountryEntity(2, 6, 6))
            add(FishCountryEntity(3, 1, 7))
            add(FishCountryEntity(2, 2, 8))
            add(FishCountryEntity(4, 4, 9))
        }

        GlobalScope.launch {

            database.fishCountryDao().insert(fishCountryList)

        }
    }

    private fun initTrophy(){
        trophyList.apply {
            add(TrophyEntity(1, 100,200,1))
            add(TrophyEntity(2, 120,200,1))
            add(TrophyEntity(3, 130,200,1))
            add(TrophyEntity(4, 140,200,1))
            add(TrophyEntity(5, 150,200,3))
            add(TrophyEntity(6, 160,200,3))
            add(TrophyEntity(7, 170,200,2))
        }

        GlobalScope.launch {

            database.trophyDao().insert(trophyList)

        }
    }

}