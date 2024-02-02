package com.aayar94.weather.data.model

data class DailyUnits(
    val sunrise: String,
    val sunset: String,
    val temperature_2m_max: String,
    val temperature_2m_min: String,
    val time: String,
    val uv_index_max: String,
    val weather_code: String
)