package com.aayar94.weather.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aayar94.weather.domain.location.LocationTracker
import com.aayar94.weather.domain.usecase.GetHomeScreenContentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getHomeScreenContentUseCase: GetHomeScreenContentUseCase,
    private val locationTracker: LocationTracker
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUIState())
    val uiState = _uiState.asStateFlow()

    private val unitFlow: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val unit = when (unitFlow.value) {
        true -> "imperial"
        else -> "metric"
    }

    fun getLocationThenWeather() {
        viewModelScope.launch {
            locationTracker.getCurrentLocation()?.let { location ->
                getWeatherData(location.latitude, location.longitude)
            }
        }
    }


    private fun getWeatherData(lat: Double, lon: Double) {
        viewModelScope.launch {
            val response = getHomeScreenContentUseCase.invoke(lat, lon, unit)
            _uiState.update {
                it.copy(
                    isLoading = false,
                    errorMessage = null,
                    homeScreenDataModel = response
                )
            }
        }
    }
}