package com.alkesh.scoreboard.common.di

import com.alkesh.scoreboard.dataSources.network.retrofitService.RetrofitService
import com.alkesh.scoreboard.dataSources.network.services.GameResultsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ApiServiceModule {
    @Provides
    fun provideGameResultApiService(retrofitService: RetrofitService): GameResultsService {
        return retrofitService.getInstance(GameResultsService::class.java)
    }
}