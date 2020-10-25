package com.yaroshevich.catchcollector.model.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "trophy_image_path")
class TrophyImagePathEntity(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var imagePath: String,
    var trophyId: Int
) {


}