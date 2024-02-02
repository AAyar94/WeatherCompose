package com.aayar94.weather.data.model

data class CurrentUnits(
    val apparent_temperature: String,
    val interval: String,
    val is_day: String,
    val precipitation: String,
    val rain: String,
    val relative_humidity_2m: String,
    val temperature_2m: String,
    val time: String,
    val weather_code: String,
    val wind_speed_10m: String
)