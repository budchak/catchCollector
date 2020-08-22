package com.yaroshevich.catchcollector.di.components

import com.yaroshevich.catchcollector.di.modules.CountryFragmentModule
import com.yaroshevich.catchcollector.ui.fragments.CountryFragment
import dagger.Subcomponent

@Subcomponent(modules = [CountryFragmentModule::class])
interface CountryFragmentComponent {

    fun inject(countryFragment: CountryFragment)
}