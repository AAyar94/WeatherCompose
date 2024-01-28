package com.aayar94.weather.domain.usecase

import com.aayar94.weather.data.Repository
import com.aayar94.weather.domain.model.HomeScreenDataModel
import java.time.LocalDateTime
import javax.inject.Inject

class GetHomeScreenContentUseCase @Inject constructor(
    private val repository: Repository
) {

    suspend operator fun invoke(lat: Double, lon: Double, unit: String): HomeScreenDataModel {
        val weatherResponse = repository.getWeather(lat = lat, lon = lon, units = unit)
        val geoLocationResponse = repository.getCityName(lat = lat, lon = lon)

        return HomeScreenDataModel(
            refreshTime = LocalDateTime.now(),
            weatherDto = weatherResponse,
            geoLocationDto = geoLocationResponse
        )
    }
}

