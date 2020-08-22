package com.yaroshevich.catchcollector.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.yaroshevich.catchcollector.App
import com.yaroshevich.catchcollector.BR
import com.yaroshevich.catchcollector.viewModels.CountryViewModel
import com.yaroshevich.catchcollector.viewModels.FishViewModel
import javax.inject.Inject

class FishFragment : RecyclerViewFragment() {

    @Inject
    lateinit var fishViewModel: FishViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        App.getInstance().initFishFragmentComponent().inject(this)

        binding?.setVariable(BR.recyclerViewModel, fishViewModel.recyclerViewModel)


        val arg = arguments

        if (arg != null) {

            val id = arg.getInt(CountryViewModel.COUNTY_TAG)

            fishViewModel.initFishListWith(id)

            Toast.makeText(context, "$id", Toast.LENGTH_LONG).show()

        }

    }



}