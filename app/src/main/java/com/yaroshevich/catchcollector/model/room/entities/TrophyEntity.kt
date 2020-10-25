package com.yaroshevich.catchcollector.model.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "trophy")
class TrophyEntity(@PrimaryKey(autoGenerate = true)var id: Int = 0, var length: Int, var weight: Int, var fishId: Int, var countryId: Int, var riverId: Int) {

}