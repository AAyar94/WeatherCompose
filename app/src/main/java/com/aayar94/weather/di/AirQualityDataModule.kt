package com.aayar94.weather.di

import com.aayar94.weather.common.Constant
import com.aayar94.weather.data.remote.AirPollutionAPI
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
object AirQualityDataModule {

    @Singleton
    @Provides
    @Named("AirQuality")
    fun provideHTTPClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    @Named("AirQuality")
    fun provideConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    @Named("AirQuality")
    fun provideRetrofit(
        @Named("AirQuality") okHttpClient: OkHttpClient,
        @Named("AirQuality") gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Singleton
    @Provides
    fun providesGeoLocationAPI(@Named("AirQuality") retrofit: Retrofit): AirPollutionAPI {
        return retrofit.create(AirPollutionAPI::class.java)
    }
}