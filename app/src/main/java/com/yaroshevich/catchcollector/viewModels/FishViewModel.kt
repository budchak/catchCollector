package com.yaroshevich.catchcollector.viewModels

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import com.yaroshevich.catchcollector.R
import com.yaroshevich.catchcollector.interfaces.ItemClickListener
import com.yaroshevich.catchcollector.model.Country
import com.yaroshevich.catchcollector.model.Fish
import com.yaroshevich.catchcollector.model.recyclerModels.FishRecyclerViewModel
import com.yaroshevich.catchcollector.repository.CatchInCountryRepository
import com.yaroshevich.catchcollector.repository.CountryRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FishViewModel(
    context: Context,
    var navController: NavController,
    var trophyParameterViewModel: TrophyParameterViewModel,
    var toolbarSettingViewModel: ToolbarSettingViewModel
) : ViewModel,
    ItemClickListener {


    val trophy = MutableLiveData<List<Fish>>()

    var country = MutableLiveData<Country?>(null)

    val recyclerViewModel = FishRecyclerViewModel(context, trophy, this)


    init {
        country.observeForever {
            toolbarSettingViewModel.toolbarTitle.postValue(it?.name)
        }
    }

    fun initFishList() {

        val countryID = trophyParameterViewModel.countryId.value

        if (countryID != null) {

            GlobalScope.launch {

                loadCountry(countryID)

                loadTrophy(countryID)

            }

        }else{
            Log.e(this.javaClass.simpleName, "ID not found")
        }

    }

    suspend fun loadCountry(countryID: Int) {

        val result = CountryRepository().getBy(countryID)

        country.postValue(result)
    }


    suspend fun loadTrophy(countryID: Int) {

        val fishes = CatchInCountryRepository().getAllById(id = countryID)

        trophy.postValue(fishes)
    }

    override fun onClick(id: Int) {

        val bundle = Bundle()

        bundle.putInt(CountryViewModel.COUNTY_TAG, id)

        navController.navigate(R.id.trophyDescriptionFragment, bundle)

    }
}
