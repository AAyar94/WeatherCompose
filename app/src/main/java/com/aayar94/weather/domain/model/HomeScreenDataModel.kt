package com.aayar94.weather.domain.model

import com.aayar94.weather.data.model.geo_location.GeoLocationDto
import com.aayar94.weather.data.model.weather.WeatherDto
import java.time.LocalDateTime

data class HomeScreenDataModel(
    val refreshTime: LocalDateTime = LocalDateTime.now(),
    val weatherDto: WeatherDto? = null,
    val geoLocationDto: GeoLocationDto? = null
)