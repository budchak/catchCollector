package com.yaroshevich.catchcollector.di.modules

import androidx.navigation.NavController
import com.yaroshevich.catchcollector.viewModels.AppFunctionViewModel
import dagger.Module
import dagger.Provides

@Module
class AppFunctionFragmentModule {

    @Provides
    fun provideAppFunctionViewModel(navigator: NavController): AppFunctionViewModel {
        return AppFunctionViewModel(navigator)
    }
}