package com.aayar94.weather.domain.repository

import com.aayar94.weather.data.model.WeatherDTO

interface WeatherRepository {

    suspend fun getWeather(lat: Double, lon: Double):WeatherDTO

}