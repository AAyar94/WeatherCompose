package com.aayar94.weather.data.remote

import com.aayar94.weather.data.model.geo_location.GeoLocationDataModel
import retrofit2.http.GET
import retrofit2.http.Query

interface GeoLocationAPI {

    @GET("/geo/1.0/reverse?limit=1")
    suspend fun getCityName(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("appid") appid: String
    ): GeoLocationDataModel
}