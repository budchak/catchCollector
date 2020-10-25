package com.yaroshevich.catchcollector.di.components

import com.yaroshevich.catchcollector.di.modules.AppFunctionFragmentModule
import com.yaroshevich.catchcollector.ui.fragments.AppFunctionFragment
import dagger.Subcomponent


@Subcomponent(modules = [AppFunctionFragmentModule::class])
interface AppFunctionFragmentComponent {

    fun inject(appFunctionFragment: AppFunctionFragment)
}