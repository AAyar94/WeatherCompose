package com.aayar94.weather.data

import com.aayar94.weather.common.Constant.Companion.SYSTEM_LANG_CODE
import com.aayar94.weather.data.model.air_pollution.AirPollutionDataModel
import com.aayar94.weather.data.model.geo_location.GeoLocationDataModel
import com.aayar94.weather.data.model.weather.WeatherDataModel
import com.aayar94.weather.data.remote.RemoteDataSource
import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
) {
    private val systemLangCode = SYSTEM_LANG_CODE
    private val langCode = when (systemLangCode) {
        "tr-TR" -> "tr"
        else -> "en"
    }

    suspend fun getWeather(
        lat: Double,
        lon: Double,
        appid: String,
        units: String,
    ): WeatherDataModel {
        return remoteDataSource.getWeather(lat, lon, appid, units, langCode)
    }

    suspend fun getCityName(lat: Double, lon: Double, appid: String): GeoLocationDataModel {
        return remoteDataSource.getCityName(lat, lon, appid)
    }

    suspend fun getAirPollution(lat: Double, lon: Double, appid: String): AirPollutionDataModel {
        return remoteDataSource.getAirQuality(lat, lon, appid)
    }


}