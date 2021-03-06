package com.yaroshevich.catchcollector.di.modules

import android.content.Context
import androidx.room.Room
import com.yaroshevich.catchcollector.model.DatabaseInitData
import com.yaroshevich.catchcollector.model.room.TrophyDatabase
import com.yaroshevich.catchcollector.viewModels.TrophyParameterViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val context: Context) {

    @Singleton
    @Provides
    fun provideContext(): Context = context

    @Singleton
    @Provides
    fun provideDatabase(context: Context): TrophyDatabase =
        Room.databaseBuilder(context, TrophyDatabase::class.java, "database")
            .build()

    @Singleton
    @Provides
    fun provideDatabaseInitData(database: TrophyDatabase): DatabaseInitData = DatabaseInitData(database)


    @Singleton
    @Provides
    fun provideTrophyParameterViewModel(): TrophyParameterViewModel = TrophyParameterViewModel()
}