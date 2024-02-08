package com.aayar94.weather.core.di

import com.aayar94.weather.data.remote.WeatherAPI
import com.aayar94.weather.data.repository.WeatherRepositoryImpl
import com.aayar94.weather.domain.usecase.GetHomeScreenContentUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideWeatherRepository(
        api: WeatherAPI
    ): WeatherRepositoryImpl {
        return WeatherRepositoryImpl(api = api)
    }

    @Provides
    @Singleton
    fun provideGetHomeScreenContentUseCase(
        repository: WeatherRepositoryImpl
    ): GetHomeScreenContentUseCase {
        return GetHomeScreenContentUseCase(repository)
    }

}