package com.alkesh.scoreboard.common.di

import com.alkesh.scoreboard.dataSources.mapper.GameResultsMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {
    @Singleton
    @Provides
    fun provideGameResultMapper(): GameResultsMapper {
        return GameResultsMapper()
    }
}