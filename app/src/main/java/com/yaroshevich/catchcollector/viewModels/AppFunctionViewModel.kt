package com.yaroshevich.catchcollector.viewModels

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import com.yaroshevich.catchcollector.R
import com.yaroshevich.catchcollector.model.Function
import com.yaroshevich.catchcollector.model.repository.AppFunctionRepository

class AppFunctionViewModel(val navigator: NavController) {

    private val repository: AppFunctionRepository = AppFunctionRepository()

    val appFunctions = MutableLiveData<List<Function>>()


    init {
        appFunctions.postValue(repository.getFunctionList())
    }


    fun onItemClick(function: String){
        when(function){
            "Погода" -> {Log.e(this::class.simpleName,"click")
            navigator.navigate(R.id.countryFragment)}
        }
    }
}