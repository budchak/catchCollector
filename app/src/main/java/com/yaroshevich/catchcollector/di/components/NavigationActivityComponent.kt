package com.yaroshevich.catchcollector.di.components

import com.yaroshevich.catchcollector.NavigationActivity
import com.yaroshevich.catchcollector.di.modules.CountryFragmentModule
import com.yaroshevich.catchcollector.di.modules.FishFragmentModule
import com.yaroshevich.catchcollector.di.modules.NavigationActivityModule
import com.yaroshevich.catchcollector.di.modules.TrophyModule
import dagger.Subcomponent

@Subcomponent(modules = [NavigationActivityModule::class])
interface NavigationActivityComponent {

    fun inject(navigationActivity: NavigationActivity)
    fun plus(countryFragmentModule: CountryFragmentModule): CountryFragmentComponent
    fun plus(fishFragmentModule: FishFragmentModule): FishFragmentComponent
    fun plus(trophyModule: TrophyModule): TrophyComponent
}