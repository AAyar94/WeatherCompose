package com.aayar94.weather.data.model.air_pollution

data class AirPollutionDataModel(
    val coord: Coord,
    val list: List<AirPollutionData>
)