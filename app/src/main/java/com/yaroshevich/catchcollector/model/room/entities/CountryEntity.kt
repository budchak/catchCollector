package com.yaroshevich.catchcollector.model.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "country")
class CountryEntity(@PrimaryKey(autoGenerate = true)var id: Int = 0, var name: String, var iconName: String)