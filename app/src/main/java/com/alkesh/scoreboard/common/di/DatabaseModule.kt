package com.alkesh.scoreboard.common.di

import android.content.Context
import androidx.room.Room
import com.alkesh.scoreboard.core.database.dao.DaoGameResult
import com.alkesh.scoreboard.core.database.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
/*    @Provides
    fun provideDaoGameResult(appDatabase: AppDatabase): DaoGameResult {
        return appDatabase.quoteDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "Game"
        ).build()
    }*/
}