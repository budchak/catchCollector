package com.yaroshevich.catchcollector.viewModels

import android.os.Bundle
import androidx.navigation.NavController
import com.yaroshevich.catchcollector.R
import com.yaroshevich.catchcollector.model.TrophyPreview

class ItemTrophyPreviewViewModel(
    val trophyPreview: TrophyPreview,
    var navigator: NavController,
    var trophyViewModel: TrophyParameterViewModel
) {


    fun onClick() {
        val bundle = Bundle()

        trophyViewModel.fishId.value = trophyPreview.fishId
        if (trophyPreview.bestTrophy != null) navigator.navigate(R.id.trophyDescriptionFragment, bundle)
        else navigator.navigate(R.id.trophyFragment)
    }
}