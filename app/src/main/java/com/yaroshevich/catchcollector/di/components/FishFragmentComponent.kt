package com.yaroshevich.catchcollector.di.components

import com.yaroshevich.catchcollector.di.modules.FishFragmentModule
import com.yaroshevich.catchcollector.ui.fragments.FishFragment
import dagger.Subcomponent

@Subcomponent(modules = [FishFragmentModule::class])
interface FishFragmentComponent {

    fun inject(fishFragment: FishFragment)
}