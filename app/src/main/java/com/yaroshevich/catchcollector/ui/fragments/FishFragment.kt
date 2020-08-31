package com.yaroshevich.catchcollector.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.yaroshevich.catchcollector.App
import com.yaroshevich.catchcollector.BR
import com.yaroshevich.catchcollector.NavigationActivity
import com.yaroshevich.catchcollector.viewModels.CountryViewModel
import com.yaroshevich.catchcollector.viewModels.FishViewModel
import javax.inject.Inject

class FishFragment : RecyclerViewFragment() {

    @Inject
    lateinit var fishViewModel: FishViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        App.getInstance().initFishFragmentComponent().inject(this)

        binding.setVariable(BR.recyclerViewModel, fishViewModel.recyclerViewModel)



        fishViewModel.initFishList()

    }


    override fun onResume() {
        super.onResume()

        (activity as NavigationActivity).changeToolbarVisibility(View.VISIBLE)

    }


}