package com.aayar94.weather.data.remote

import com.aayar94.weather.data.model.air_pollution.AirPollutionDataModel
import retrofit2.http.GET
import retrofit2.http.Query

interface  AirPollutionAPI {

    @GET("/data/2.5/air_pollution?")
    suspend fun getAirPollution(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("appid") appid: String
    ) : AirPollutionDataModel

}