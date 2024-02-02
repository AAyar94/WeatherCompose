package com.aayar94.weather.data.model

data class Hourly(
    val apparent_temperature: List<Double>,
    val dew_point_2m: List<Double>,
    val pressure_msl: List<Double>,
    val rain: List<Double>,
    val relative_humidity_2m: List<Int>,
    val showers: List<Double>,
    val temperature_2m: List<Double>,
    val time: List<String>,
    val weather_code: List<Int>,
    val wind_speed_10m: List<Double>
)