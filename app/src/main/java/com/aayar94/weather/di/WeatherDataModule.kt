package com.aayar94.weather.di

import com.aayar94.weather.common.Constant
import com.aayar94.weather.data.remote.WeatherDataAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WeatherDataModule {

    @Singleton
    @Provides
    @Named("Weather")
    fun provideHTTPClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    @Named("Weather")
    fun provideConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    @Named("Weather")
    fun provideRetrofit(
        @Named("Weather") okHttpClient: OkHttpClient,
        @Named("Weather") gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Singleton
    @Provides
    fun providesWeatherAPI(@Named("Weather") retrofit: Retrofit): WeatherDataAPI {
        return retrofit.create(WeatherDataAPI::class.java)
    }
}