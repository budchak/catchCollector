package com.yaroshevich.catchcollector.model.repository

import com.yaroshevich.catchcollector.App
import com.yaroshevich.catchcollector.model.TrophyPreview

class TrophyPreviewRepository {


    suspend fun getAll(countryId: Int): List<TrophyPreview> {
        return App.getInstance().database.trophyPreviewDao().getPreview(countryId)
    }
}