package com.aayar94.weather.data

import com.aayar94.weather.core.util.Constant
import com.aayar94.weather.core.util.Constant.API_KEY
import com.aayar94.weather.data.model.air_pollution.AirPollutionDto
import com.aayar94.weather.data.model.geo_location.GeoLocationDto
import com.aayar94.weather.data.model.weather.WeatherDto
import com.aayar94.weather.data.remote.RemoteDataSource
import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
) {
    private val systemLangCode = Constant.SYSTEM_LANG_CODE
    private val langCode = when (systemLangCode) {
        "tr-TR" -> "tr"
        else -> "en"
    }

    suspend fun getWeather(
        lat: Double,
        lon: Double,
        appid: String = API_KEY,
        units: String,
    ): WeatherDto? {
        return remoteDataSource.getWeather(lat, lon, appid, units, langCode)
    }

    suspend fun getCityName(
        lat: Double,
        lon: Double,
        appid: String = API_KEY
    ): GeoLocationDto? {
        return remoteDataSource.getCityName(lat, lon, appid)
    }

    suspend fun getAirPollution(
        lat: Double,
        lon: Double,
        appid: String = API_KEY
    ): AirPollutionDto {
        return remoteDataSource.getAirQuality(lat, lon, appid)
    }


}