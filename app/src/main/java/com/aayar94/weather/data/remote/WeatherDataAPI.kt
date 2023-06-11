package com.aayar94.weather.data.remote

import com.aayar94.weather.data.model.weather.WeatherDataModel
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherDataAPI {

    @GET("/data/3.0/onecall?exclude=minutely,alerts")
    suspend fun getWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") apiKey: String,
        @Query("units") units: String,
        @Query("lang") lang: String
    ): WeatherDataModel
}

