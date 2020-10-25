package com.yaroshevich.catchcollector.di.components

import com.yaroshevich.catchcollector.NavigationActivity
import com.yaroshevich.catchcollector.di.modules.*
import com.yaroshevich.catchcollector.di.spore.ActivitySpore
import dagger.Subcomponent

@ActivitySpore
@Subcomponent(modules = [NavigationActivityModule::class])
interface NavigationActivityComponent {

    fun inject(navigationActivity: NavigationActivity)
    fun plus(countryFragmentModule: CountryFragmentModule): CountryFragmentComponent
    fun plus(fishFragmentModule: FishFragmentModule): FishFragmentComponent
    fun plus(trophyModule: TrophyModule): TrophyComponent
    fun plus(appFunctionModule: AppFunctionFragmentModule): AppFunctionFragmentComponent
}