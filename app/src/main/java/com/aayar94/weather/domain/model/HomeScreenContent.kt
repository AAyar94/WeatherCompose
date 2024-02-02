package com.aayar94.weather.domain.model

import com.aayar94.weather.data.model.Daily

data class HomeScreenContent(
    val cityName: String,
    val degree:Double,
    val date: String,
    val uvIndex: Int,
    val windSpeed: Double,
    val humidity: Int,
    val list: Daily
)