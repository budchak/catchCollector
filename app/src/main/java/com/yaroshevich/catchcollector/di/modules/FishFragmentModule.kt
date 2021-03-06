package com.yaroshevich.catchcollector.di.modules

import android.content.Context
import androidx.navigation.NavController
import com.yaroshevich.catchcollector.viewModels.FishViewModel
import com.yaroshevich.catchcollector.viewModels.ToolbarSettingViewModel
import com.yaroshevich.catchcollector.viewModels.TrophyParameterViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Named


@Module
class FishFragmentModule {


    @Provides
    fun provideFishViewModel(
        @Named("ActivityContext") context: Context,
        navController: NavController,
        trophyParameterViewModel: TrophyParameterViewModel,
        toolbarSettingViewModel: ToolbarSettingViewModel
    ): FishViewModel {
        return FishViewModel(context, navController, trophyParameterViewModel, toolbarSettingViewModel)
    }

}