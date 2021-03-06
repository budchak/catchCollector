package com.yaroshevich.catchcollector.viewModels

import android.content.Context
import android.os.Bundle

import androidx.navigation.NavController

import com.yaroshevich.catchcollector.R
import com.yaroshevich.catchcollector.interfaces.ItemClickListener

import com.yaroshevich.catchcollector.model.recyclerModels.CountryRecyclerViewModel


class CountryViewModel(
    var context: Context,
    var navController: NavController,
    var trophyParameterViewModel: TrophyParameterViewModel,
    var toolbarSettingViewModel: ToolbarSettingViewModel
) : ViewModel, ItemClickListener {


    private val recyclerViewModel = CountryRecyclerViewModel(context, this)


    fun getRecyclerModel() = recyclerViewModel


    override fun onClick(id: Int) {

        trophyParameterViewModel.countryId.postValue(id)

        navController.navigate(R.id.fishFragment)

    }

    companion object {

        val COUNTY_TAG = "country id"

    }
}
