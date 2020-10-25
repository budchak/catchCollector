package com.yaroshevich.catchcollector.model.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "fish")
class FishEntity(@PrimaryKey(autoGenerate = true)var id: Int = 0, var name: String, var sdb: String, var imagePath: String) {
}