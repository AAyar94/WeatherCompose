package com.aayar94.weather.data.model

data class HourlyUnits(
    val apparent_temperature: String,
    val dew_point_2m: String,
    val pressure_msl: String,
    val rain: String,
    val relative_humidity_2m: String,
    val showers: String,
    val temperature_2m: String,
    val time: String,
    val weather_code: String,
    val wind_speed_10m: String
)