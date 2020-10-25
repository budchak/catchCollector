package com.yaroshevich.catchcollector.viewModels

import androidx.lifecycle.MutableLiveData
import com.yaroshevich.catchcollector.model.Trophy

class TrophyViewModel {

    var findByCountryEnable = MutableLiveData<Boolean>(false)

    var findByFishNameEnable = MutableLiveData<Boolean>(false)


    var liveTrophy = MutableLiveData<List<Trophy>>()

}