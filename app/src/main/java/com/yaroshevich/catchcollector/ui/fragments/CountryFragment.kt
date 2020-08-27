package com.yaroshevich.catchcollector.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.yaroshevich.catchcollector.App
import com.yaroshevich.catchcollector.BR
import com.yaroshevich.catchcollector.NavigationActivity
import com.yaroshevich.catchcollector.viewModels.CountryViewModel
import javax.inject.Inject

class CountryFragment : RecyclerViewFragment(){

    @Inject
    lateinit var countryViewModel: CountryViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        App.getInstance().initCountryFragmentComponent().inject(this)

        binding?.setVariable(BR.recyclerViewModel, countryViewModel.getRecyclerModel())


    }

    override fun onResume() {
        super.onResume()

        (activity as NavigationActivity).setToolbarTitle("My trophy")
    }
}