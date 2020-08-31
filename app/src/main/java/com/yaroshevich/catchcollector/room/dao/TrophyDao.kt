package com.yaroshevich.catchcollector.room.dao

import androidx.room.*

import com.yaroshevich.catchcollector.room.entities.TrophyEntity


@Dao
interface TrophyDao {


    @Query("SELECT * FROM trophy")
    suspend fun getAll(): List<TrophyEntity>

    @Query("SELECT * FROM trophy WHERE fishId = :fishId")
    suspend fun getBy(fishId: Int): List<TrophyEntity>?

    @Query("SELECT * FROM trophy WHERE fishId = :fishId ORDER BY length DESC")
    suspend fun getBest(fishId: Int): TrophyEntity?

    @Query("SELECT * FROM trophy WHERE fishId = :fishId AND countryId = :countryId ORDER BY length DESC")
    suspend fun getBest(fishId: Int, countryId: Int): TrophyEntity?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(trophyEntity: TrophyEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(trophyEntity: List<TrophyEntity>)

    @Update
    fun update(trophyEntity: TrophyEntity)

    @Delete
    fun delete(trophyEntity: TrophyEntity)
}