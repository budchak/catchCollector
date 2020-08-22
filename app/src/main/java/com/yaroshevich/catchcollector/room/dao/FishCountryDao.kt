package com.yaroshevich.catchcollector.room.dao

import androidx.room.*
import com.yaroshevich.catchcollector.room.entities.FishCountryEntity
import com.yaroshevich.catchcollector.room.entities.FishWithCountry

@Dao
interface FishCountryDao {

    @Query("SELECT * FROM fish_country")
    suspend fun getAll(): List<FishCountryEntity>


    @Query("SELECT * from fish_country Where countryId = :id")
    fun getAllWithCountry(id: Int): FishWithCountry

    @Query("SELECT * FROM fish_country WHERE countryId = :id")
    suspend fun getById(id: Int):  FishCountryEntity?

    @Query("SELECT * FROM fish_country WHERE countryId = :id")
    suspend fun getAllById(id: Int): List<FishCountryEntity>?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(countryEntity: FishCountryEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(countryEntity: List<FishCountryEntity>)

    @Update
    fun update(countryEntity: FishCountryEntity)

    @Delete
    fun delete(countryEntity: FishCountryEntity)
}