package com.yaroshevich.catchcollector.di.modules

import android.content.Context
import androidx.navigation.NavController
import com.yaroshevich.catchcollector.viewModels.CountryViewModel
import com.yaroshevich.catchcollector.viewModels.ToolbarSettingViewModel
import com.yaroshevich.catchcollector.viewModels.TrophyParameterViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Named


@Module
class CountryFragmentModule() {

    @Provides
    fun provideCountryViewModel(
        @Named("ActivityContext") context: Context,
        navController: NavController,
        trophyParameterViewModel: TrophyParameterViewModel,
        toolbarSettingViewModel: ToolbarSettingViewModel
    ): CountryViewModel {
        return CountryViewModel(
            context,
            navController,
            trophyParameterViewModel,
            toolbarSettingViewModel
        )
    }
}