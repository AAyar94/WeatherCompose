package com.aayar94.weather.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aayar94.weather.common.Constant
import com.aayar94.weather.data.Repository
import com.aayar94.weather.data.model.geo_location.GeoLocationDataModel
import com.aayar94.weather.data.model.weather.WeatherDataModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {

    val weatherResponse = MutableStateFlow<WeatherDataModel?>(null)
    val geoLocationResponse = MutableStateFlow<GeoLocationDataModel?>(null)

    private val unitFlow: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val unit = when (unitFlow.value) {
        true -> "imperial"
        else -> "metric"
    }

    fun getWeatherData(lat: Double, lon: Double) {
        viewModelScope.launch {
            val result = repository.getWeather(lat, lon, Constant.API_KEY, unit)
            result?.let {
                weatherResponse.value = it
            }
        }
    }

    fun getGeoLocation(lat: Double, lon: Double) {
        viewModelScope.launch {
            val result = repository.getCityName(lat, lon, Constant.API_KEY)
            result?.let {
                geoLocationResponse.value = it
            }
        }
    }
}