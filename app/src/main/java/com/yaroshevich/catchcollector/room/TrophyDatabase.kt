package com.yaroshevich.catchcollector.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yaroshevich.catchcollector.room.dao.CountryDao
import com.yaroshevich.catchcollector.room.dao.FishCountryDao
import com.yaroshevich.catchcollector.room.dao.FishDao
import com.yaroshevich.catchcollector.room.dao.TrophyDao
import com.yaroshevich.catchcollector.room.entities.CountryEntity
import com.yaroshevich.catchcollector.room.entities.FishCountryEntity
import com.yaroshevich.catchcollector.room.entities.FishEntity
import com.yaroshevich.catchcollector.room.entities.TrophyEntity

@Database(
    entities = [FishEntity::class, CountryEntity::class, FishCountryEntity::class, TrophyEntity::class],
    version = 1
)
abstract class TrophyDatabase : RoomDatabase() {
    abstract fun fishDao(): FishDao
    abstract fun countryDao(): CountryDao
    abstract fun trophyDao(): TrophyDao
    abstract fun fishCountryDao(): FishCountryDao

}