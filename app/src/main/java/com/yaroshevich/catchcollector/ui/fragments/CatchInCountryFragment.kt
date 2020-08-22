package com.yaroshevich.catchcollector.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.yaroshevich.catchcollector.BR
import com.yaroshevich.catchcollector.viewModels.CountryViewModel

class CatchInCountryFragment: RecyclerViewFragment() {

    lateinit var countryViewModel: CountryViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        countryViewModel = CountryViewModel(requireContext(), findNavController())

        binding?.setVariable(BR.recyclerViewModel, countryViewModel.getRecyclerModel())

        val arg = arguments
        if (arg != null) {
            val id = arg.getInt(CountryViewModel.COUNTY_TAG)
            Toast.makeText(context, "$id", Toast.LENGTH_LONG).show()
        }
    }
}