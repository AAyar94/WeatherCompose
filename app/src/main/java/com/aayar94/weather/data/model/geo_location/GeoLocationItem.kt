package com.aayar94.weather.data.model.geo_location

data class GeoLocationItem(
    val country: String,
    val lat: Double,
    val local_names: LocalNames,
    val lon: Double,
    val name: String
)