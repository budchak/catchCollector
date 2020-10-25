package com.yaroshevich.catchcollector.model.room.dao

import androidx.room.*
import com.yaroshevich.catchcollector.model.room.entities.CountryEntity

@Dao
interface CountryDao {

    @Query("SELECT * FROM country")
    suspend fun getAll(): List<CountryEntity>

    @Query("SELECT * FROM country WHERE id = :countryId")
    suspend fun getById(countryId: Int): CountryEntity?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(countryEntity: CountryEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(countryEntity: List<CountryEntity>)

    @Update
    fun update(countryEntity: CountryEntity)

    @Delete
    fun delete(countryEntity: CountryEntity)


    @Query("SELECT * FROM country WHERE name LIKE '%' || :request || '%'")
    suspend fun search(request: String): List<CountryEntity>
}