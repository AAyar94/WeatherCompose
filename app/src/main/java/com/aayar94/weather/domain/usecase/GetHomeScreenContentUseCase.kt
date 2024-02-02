package com.aayar94.weather.domain.usecase

import com.aayar94.weather.domain.model.HomeScreenContent
import com.aayar94.weather.domain.repository.WeatherRepository
import kotlin.math.roundToInt

class GetHomeScreenContentUseCase(val repository: WeatherRepository) {

    suspend operator fun invoke(lat: Double, lon: Double): HomeScreenContent {
        val response = repository.getWeather(lat, lon)
        return HomeScreenContent(
            cityName = response.current.temperature_2m.toString(),
            degree=response.current.temperature_2m,
            date = response.current.time.toString(),
            uvIndex = response.current.wind_speed_10m.roundToInt(),
            windSpeed = response.current.wind_speed_10m,
            humidity = response.current.relative_humidity_2m,
            list = response.daily
        )
    }

}