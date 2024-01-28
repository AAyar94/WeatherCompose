package com.aayar94.weather.data.remote

import com.aayar94.weather.data.model.air_pollution.AirPollutionDto
import com.aayar94.weather.data.model.geo_location.GeoLocationDto
import com.aayar94.weather.data.model.weather.WeatherDto
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
    ): WeatherDto? {
        return try {
            val result = weatherDataAPI.getWeather(lat, lon,appid, units, lang)
            if (result.isSuccessful) {
                result.body()
            } else {
                null
            }
        }catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    suspend fun getCityName(lat: Double, lon: Double, appid: String): GeoLocationDto? {
        return try {
            val result = geoLocationNameDataAPI.getCityName(lat, lon, appid)
            if (result.isSuccessful) {
                result.body()
            } else {
                null
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    suspend fun getAirQuality(lat: Double, lon: Double, appid: String): AirPollutionDto {
        return airPollutionAPI.getAirPollution(lat, lon, appid)
    }

}