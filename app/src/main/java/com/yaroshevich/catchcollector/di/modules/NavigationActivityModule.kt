package com.yaroshevich.catchcollector.di.modules

import android.content.Context
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.yaroshevich.catchcollector.NavigationActivity
import com.yaroshevich.catchcollector.R
import com.yaroshevich.catchcollector.di.spore.ActivitySpore
import com.yaroshevich.catchcollector.viewModels.ToolbarSettingViewModel
import com.yaroshevich.catchcollector.viewModels.TrophyViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class NavigationActivityModule(val navigationActivity: NavigationActivity) {


    @Provides
    @Named(value = "ActivityContext")
    fun provideContext(): Context {
        return navigationActivity
    }

    @Provides
    fun provideNavController(): NavController {
        return Navigation.findNavController(navigationActivity, R.id.fragment);
    }

    @ActivitySpore
    @Provides
    fun provideToolbarSettingViewModel(): ToolbarSettingViewModel {
        return ToolbarSettingViewModel()
    }

    @ActivitySpore
    @Provides
    fun provideTrophyViewModel(): TrophyViewModel = TrophyViewModel()



}