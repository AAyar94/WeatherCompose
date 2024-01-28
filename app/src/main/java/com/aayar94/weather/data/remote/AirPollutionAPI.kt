package com.aayar94.weather.data.remote

import com.aayar94.weather.data.model.air_pollution.AirPollutionDto
import retrofit2.http.GET
import retrofit2.http.Query

interface  AirPollutionAPI {

    @GET("/data/2.5/air_pollution?")
    suspend fun getAirPollution(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") apiKey: String
    ) : AirPollutionDto

}