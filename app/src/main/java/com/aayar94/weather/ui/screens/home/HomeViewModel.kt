package com.aayar94.weather.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aayar94.weather.common.Constant.Companion.API_KEY
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
            weatherResponse.value = repository.getWeather(lat, lon, API_KEY, unit)
        }
    }

    fun getGeoLocation(lat: Double, lon: Double) {
        viewModelScope.launch {
            geoLocationResponse.value = repository.getCityName(lat, lon, API_KEY)
        }
    }
}