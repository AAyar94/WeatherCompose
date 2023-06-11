package com.aayar94.weather.data.remote

import com.aayar94.weather.data.model.air_pollution.AirPollutionDataModel
import com.aayar94.weather.data.model.geo_location.GeoLocationDataModel
import com.aayar94.weather.data.model.weather.WeatherDataModel
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val weatherDataAPI: WeatherDataAPI,
    private val geoLocationNameDataAPI: GeoLocationAPI,
    private val airPollutionAPI: AirPollutionAPI,
) {
    suspend fun getWeather(
        lat: Double,
        lon: Double,
        appid: String,
        units: String,
        lang: String,
    ): WeatherDataModel {
        return weatherDataAPI.getWeather(lat, lon, appid, units, lang)
    }

    suspend fun getCityName(lat: Double, lon: Double, appid: String): GeoLocationDataModel {
        return geoLocationNameDataAPI.getCityName(lat, lon, appid)
    }

    suspend fun getAirQuality(lat: Double, lon: Double, appid: String): AirPollutionDataModel {
        return airPollutionAPI.getAirPollution(lat, lon, appid)
    }

}