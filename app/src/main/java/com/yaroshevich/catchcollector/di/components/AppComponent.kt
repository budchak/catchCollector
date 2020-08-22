package com.yaroshevich.catchcollector.di.components

import com.yaroshevich.catchcollector.App
import com.yaroshevich.catchcollector.di.modules.AppModule
import com.yaroshevich.catchcollector.di.modules.NavigationActivityModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(app: App)
    fun plus(navigationActivityModule: NavigationActivityModule): NavigationActivityComponent
}