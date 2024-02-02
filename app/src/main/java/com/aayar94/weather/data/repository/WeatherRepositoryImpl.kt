package com.aayar94.weather.data.repository

import com.aayar94.weather.data.model.WeatherDTO
import com.aayar94.weather.data.remote.WeatherAPI
import com.aayar94.weather.domain.repository.WeatherRepository

class WeatherRepositoryImpl(val api: WeatherAPI) : WeatherRepository {
    override suspend fun getWeather(lat: Double, lon: Double): WeatherDTO {
        return api.getWeather(latitude = lat, longitude = lon)
    }
}