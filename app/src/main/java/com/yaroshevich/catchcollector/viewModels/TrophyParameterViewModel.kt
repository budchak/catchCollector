package com.yaroshevich.catchcollector.viewModels

import androidx.lifecycle.MutableLiveData
import com.yaroshevich.catchcollector.model.Country
import com.yaroshevich.catchcollector.model.Fish
import com.yaroshevich.catchcollector.repository.TrophyRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TrophyParameterViewModel {

    var countryId = MutableLiveData<Int>()

    var fishId = MutableLiveData<Int>()

}