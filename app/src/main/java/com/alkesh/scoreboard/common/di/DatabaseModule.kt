package com.alkesh.scoreboard.common.di

import android.content.Context
import androidx.room.Room
import com.alkesh.scoreboard.dataSources.database.dao.DaoGameResult
import com.alkesh.scoreboard.dataSources.database.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "Game"
        ).build()
    }

    @Singleton
    @Provides
    fun provideDaoGameResult(appDatabase: AppDatabase): DaoGameResult {
        return appDatabase.quoteDao()
    }


}