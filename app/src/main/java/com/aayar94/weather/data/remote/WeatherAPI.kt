package com.aayar94.weather.data.remote

import com.aayar94.weather.data.model.WeatherDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {
    @GET("&current=temperature_2m,relative_humidity_2m,apparent_temperature,is_day,precipitation,rain,weather_code,wind_speed_10m&hourly=temperature_2m,relative_humidity_2m,dew_point_2m,apparent_temperature,rain,showers,weather_code,pressure_msl,wind_speed_10m&daily=weather_code,temperature_2m_max,temperature_2m_min,sunrise,sunset,uv_index_max&timezone=Europe%2FMoscow")
    fun getWeather(
        @Query("latitude") latitude: Double,
        @Query("longutide") longitude: Double
    ): WeatherDTO
}