package com.yaroshevich.catchcollector.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yaroshevich.catchcollector.model.room.dao.*
import com.yaroshevich.catchcollector.model.room.entities.*

@Database(
    entities = [FishEntity::class, CountryEntity::class, FishCountryEntity::class, TrophyEntity::class, TrophyImagePathEntity::class],
    version = 1
)
abstract class TrophyDatabase : RoomDatabase() {
    abstract fun fishDao(): FishDao
    abstract fun countryDao(): CountryDao
    abstract fun trophyDao(): TrophyDao
    abstract fun fishCountryDao(): FishCountryDao
    abstract fun trophyPreviewDao(): TrophyPreviewDao
    abstract fun trophyImagePathDao(): TrophyImagePathDao

}