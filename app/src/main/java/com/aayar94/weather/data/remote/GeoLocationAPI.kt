package com.aayar94.weather.data.remote

import com.aayar94.weather.data.model.geo_location.GeoLocationDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GeoLocationAPI {

    @GET("/geo/1.0/reverse?limit=1")
    suspend fun getCityName(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") apiKey: String
    ): Response<GeoLocationDto>
}