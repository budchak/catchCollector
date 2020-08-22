package com.yaroshevich.catchcollector.viewModels

import android.content.Context
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import com.yaroshevich.catchcollector.R
import com.yaroshevich.catchcollector.interfaces.ItemClickListener
import com.yaroshevich.catchcollector.model.Fish
import com.yaroshevich.catchcollector.model.recyclerModels.FishRecyclerViewModel
import com.yaroshevich.catchcollector.repository.CatchInCountryRepository
import com.yaroshevich.catchcollector.repository.TrophyRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FishViewModel(context: Context, var navController: NavController) : ViewModel,
    ItemClickListener {

    val trophy = MutableLiveData<List<Fish>>()


    val recyclerViewModel = FishRecyclerViewModel(context, trophy, this)

    fun initFishListWith(countryID: Int) {
        GlobalScope.launch {

            loadTrophy(countryID)

        }

    }


    suspend fun loadTrophy(countryID: Int) {

        val fishes = CatchInCountryRepository().getAllById(id = countryID)

        trophy.postValue(fishes)
    }

    override fun onClick(id: Int) {

        val bundle = Bundle()

        bundle.putInt(CountryViewModel.COUNTY_TAG, id)

        navController.navigate(R.id.trophyFragment, bundle)

    }
}
