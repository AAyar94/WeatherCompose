package com.aayar94.weather.ui.screens.home

import androidx.lifecycle.MutableLiveData
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

    val weatherResponse: MutableLiveData<WeatherDataModel> = MutableLiveData()
    val geoLocationResponse: MutableLiveData<GeoLocationDataModel> = MutableLiveData()

    private val unitFlow: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val unit = when (unitFlow.value) {
        true -> "imperial"
        else -> "metric"
    }

    fun getWeatherData(lat: Double, lon: Double) {
        viewModelScope.launch {
            weatherResponse.postValue(repository.getWeather(lat, lon, API_KEY, unit))
        }

    }

    fun getGeoLocation(lat: Double, lon: Double) {
        viewModelScope.launch {
            geoLocationResponse.postValue(repository.getCityName(lat, lon, API_KEY))
        }
    }

}