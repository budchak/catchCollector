package com.yaroshevich.catchcollector.di.components

import com.yaroshevich.catchcollector.di.modules.TrophyModule
import com.yaroshevich.catchcollector.ui.fragments.TrophyFragment
import dagger.Subcomponent

@Subcomponent(modules = [TrophyModule::class])
interface TrophyComponent {

    fun inject(fragment: TrophyFragment)
}