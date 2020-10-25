package com.yaroshevich.catchcollector

import android.app.Application
import com.yaroshevich.catchcollector.di.components.*
import com.yaroshevich.catchcollector.di.modules.*
import com.yaroshevich.catchcollector.model.DatabaseInitData
import com.yaroshevich.catchcollector.model.room.TrophyDatabase
import javax.inject.Inject

class App : Application() {

    @Inject
    lateinit var databaseInitData: DatabaseInitData

    @Inject
    lateinit var database: TrophyDatabase

    private lateinit var appComponent: AppComponent

    private lateinit var navigationActivityComponent: NavigationActivityComponent

    private lateinit var countryFragmentComponent: CountryFragmentComponent

    private lateinit var fishFragmentComponent: FishFragmentComponent

    private lateinit var trophyComponent: TrophyComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(applicationContext)).build()
        appComponent.inject(this)
        setInstance(this)
        databaseInitData.initData()
    }


    fun initNavigationActivityComponent(navigationActivity: NavigationActivity): NavigationActivityComponent {
        navigationActivityComponent =
            appComponent.plus(NavigationActivityModule(navigationActivity))

        return navigationActivityComponent
    }

    fun initCountryFragmentComponent(): CountryFragmentComponent {
        countryFragmentComponent = navigationActivityComponent.plus(CountryFragmentModule())
        return countryFragmentComponent
    }

    fun initFishFragmentComponent(): FishFragmentComponent {
        fishFragmentComponent = navigationActivityComponent.plus(FishFragmentModule())
        return fishFragmentComponent
    }

    fun initTrophyComponent(): TrophyComponent {
        trophyComponent = navigationActivityComponent.plus(TrophyModule())
        return trophyComponent
    }

    fun initAppFunctionComponent(): AppFunctionFragmentComponent {
        return navigationActivityComponent.plus(AppFunctionFragmentModule())

    }

    companion object {

        private lateinit var app: App
        private fun setInstance(app: App) {
            this.app = app
        }

        fun getInstance() = app
    }
}