package com.yaroshevich.catchcollector.di.modules

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.yaroshevich.catchcollector.ui.fragments.CatchInCountryFragment
import com.yaroshevich.catchcollector.viewModels.CountryViewModel
import com.yaroshevich.catchcollector.viewModels.ToolbarSettingViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Named


@Module
class CountryFragmentModule() {

    @Provides
    fun provideCountryViewModel(@Named("ActivityContext") context: Context, navController: NavController, toolbarSettingViewModel: ToolbarSettingViewModel): CountryViewModel{
        return CountryViewModel(context, navController, toolbarSettingViewModel)
    }
}