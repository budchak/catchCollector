package com.yaroshevich.catchcollector.model.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "fish_country")
class FishCountryEntity(var countryId: Int, var fishId: Int, @PrimaryKey(autoGenerate = true) var id: Int = 0)