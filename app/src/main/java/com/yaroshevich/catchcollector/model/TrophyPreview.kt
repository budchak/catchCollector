package com.yaroshevich.catchcollector.model

class TrophyPreview(
    var countryId: Int,
    var fishId: Int,
    var name: String,
    var previewImage: String,
    var bestTrophy: Trophy? = null
) {
}