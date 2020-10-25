package com.yaroshevich.catchcollector.model

import com.yaroshevich.catchcollector.model.room.TrophyDatabase
import com.yaroshevich.catchcollector.model.room.entities.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DatabaseInitData(val database: TrophyDatabase) {


    var countryList = mutableListOf<CountryEntity>()

    val fishList = mutableListOf<FishEntity>()

    val fishCountryList = mutableListOf<FishCountryEntity>()

    val trophyList = mutableListOf<TrophyEntity>()

    val trophyImage = mutableListOf<TrophyImagePathEntity>()

    fun initData() {
        initCountryList()
        initFish()
        initFishCountry()
        initTrophy()
        initTrophyImage()
    }

    fun initTrophyImage() {
        trophyImage.apply {
            add(TrophyImagePathEntity(1, "/images/country/title_country_belarus.png", 1))
            add(TrophyImagePathEntity(2, "/images/country/title_country_belarus.png", 2))
            add(TrophyImagePathEntity(3, "/images/country/title_country_belarus.png", 3))
            add(TrophyImagePathEntity(4, "/images/country/title_country_belarus.png", 4))
            add(TrophyImagePathEntity(5, "/images/country/title_country_belarus.png", 5))
            add(TrophyImagePathEntity(6, "/images/carp.jpg", 7))

            GlobalScope.launch {

                database.trophyImagePathDao().insert(trophyImage)

            }
        }
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
            add(FishEntity(1, "Карп", "1", "/images/fish/grass_carp.png"))
            add(FishEntity(2, "Карась", "1", "/images/fish/grass_carp.png"))
            add(FishEntity(3, "Карась серебрянный", "1", "/images/fish/grass_carp.png"))
            add(FishEntity(4, "Плотва", "1", "/images/fish/grass_carp.png"))
            add(FishEntity(5, "Налим", "1", "/images/fish/grass_carp.png"))
            add(FishEntity(6, "Сельдь", "2", "/images/fish/grass_carp.png"))
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

    private fun initTrophy() {
        trophyList.apply {
            add(TrophyEntity(1, 100, 200, 1, 1, 1))
            add(TrophyEntity(2, 120, 200, 1, 1, 1))
            add(TrophyEntity(3, 130, 200, 1, 1, 1))
            add(TrophyEntity(4, 140, 200, 1, 1, 1))
            add(TrophyEntity(5, 150, 200, 1, 1, 1))
            add(TrophyEntity(6, 160, 200, 1, 1, 1))
            add(TrophyEntity(7, 170, 200, 1, 1, 1))
        }

        GlobalScope.launch {

            database.trophyDao().insert(trophyList)

        }
    }

}