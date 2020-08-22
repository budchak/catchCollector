package com.yaroshevich.catchcollector

import android.app.Application
import com.yaroshevich.catchcollector.di.components.*
import com.yaroshevich.catchcollector.di.modules.AppModule
import com.yaroshevich.catchcollector.di.modules.CountryFragmentModule
import com.yaroshevich.catchcollector.di.modules.FishFragmentModule
import com.yaroshevich.catchcollector.di.modules.NavigationActivityModule
import com.yaroshevich.catchcollector.model.DatabaseInitData
import com.yaroshevich.catchcollector.room.TrophyDatabase
import dagger.Component
import javax.inject.Inject

class App : Application() {

    @Inject
    lateinit var databaseInitData: DatabaseInitData

    @Inject
    lateinit var database: TrophyDatabase

    lateinit var appComponent: AppComponent

    lateinit var navigationActivityComponent: NavigationActivityComponent

    lateinit var countryFragmentComponent: CountryFragmentComponent

    lateinit var fishFragmentComponent: FishFragmentComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(applicationContext)).build()
        appComponent.inject(this)
        setInstance(this)
        databaseInitData.initData()
    }


    fun initNavigationActivityComponent(navigationActivity: NavigationActivity): NavigationActivityComponent{
        navigationActivityComponent = appComponent.plus(NavigationActivityModule(navigationActivity))

        return navigationActivityComponent
    }

    fun initCountryFragmentComponent(): CountryFragmentComponent{
        countryFragmentComponent = navigationActivityComponent.plus(CountryFragmentModule())
        return countryFragmentComponent
    }

    fun initFishFragmentComponent(): FishFragmentComponent {
        fishFragmentComponent = navigationActivityComponent.plus(FishFragmentModule())
        return fishFragmentComponent
    }

    companion object {

        private lateinit var app: App
        private fun setInstance(app: App) {
            this.app = app
        }

        fun getInstance() = app
    }
}