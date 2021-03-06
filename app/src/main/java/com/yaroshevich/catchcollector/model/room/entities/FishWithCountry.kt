package com.yaroshevich.catchcollector.model.room.entities

import androidx.room.Relation

class FishWithCountry (
    var countryId: Int,
    var fishId: Int,
    @Relation(parentColumn = "fishId", entityColumn = "id")
    var fishList: List<FishEntity>){
}