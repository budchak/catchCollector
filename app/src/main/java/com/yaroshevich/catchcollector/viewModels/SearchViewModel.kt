package com.yaroshevich.catchcollector.viewModels

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.yaroshevich.catchcollector.model.Country
import com.yaroshevich.catchcollector.model.repository.CountryRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SearchViewModel(var owner: LifecycleOwner) {

     var countryRepository: CountryRepository = CountryRepository()

    val searchRequestText = MutableLiveData<String>("")

    val liveCountry = MutableLiveData<List<Country>>()

    init {
        searchRequestText.observe(owner, Observer {
            search(it)
        })
    }

    private fun search(string: String){

        GlobalScope.launch {
            val result = countryRepository.search(string)
            result.forEach {
                Log.e("ViewModel", "${it.id} + ${it.name}")
            }
            liveCountry.postValue(result)
        }
    }
}