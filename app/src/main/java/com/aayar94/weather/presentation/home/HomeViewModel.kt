package com.aayar94.weather.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aayar94.weather.domain.usecase.GetHomeScreenContentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeScreenContentUseCase: GetHomeScreenContentUseCase
) : ViewModel() {

    private var _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    fun getWeather(lat: Double, lon: Double) {
        viewModelScope.launch {
            val response = homeScreenContentUseCase.invoke(lat = lat, lon = lon)
            _uiState.update {
                it.copy(
                    data = response
                )
            }
        }
    }

}