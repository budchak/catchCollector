package com.yaroshevich.catchcollector.model.room.dao

import androidx.room.*
import com.yaroshevich.catchcollector.model.room.entities.FishEntity

@Dao
interface FishDao {

    @Query("SELECT * FROM fish")
    suspend fun getAll(): List<FishEntity>

    @Query("SELECT * FROM fish WHERE id = :fishId")
    suspend fun getById(fishId: Int): FishEntity?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend  fun insert(fishEntity: FishEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend  fun insert(fishEntity: List<FishEntity>)

    @Update
    fun update(fishEntity: FishEntity)

    @Delete
    fun delete(fishEntity: FishEntity)
}