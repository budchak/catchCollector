package com.yaroshevich.catchcollector.di.modules

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.yaroshevich.catchcollector.App
import com.yaroshevich.catchcollector.NavigationActivity
import com.yaroshevich.catchcollector.model.DatabaseInitData
import com.yaroshevich.catchcollector.room.TrophyDatabase
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



}