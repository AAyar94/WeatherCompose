package com.aayar94.weather.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aayar94.weather.core.util.Resource
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
    private val homeScreenContentUseCase: GetHomeScreenContentUseCase,
    private val locationTracker: LocationTracker
) : ViewModel() {

    private var _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    fun getWeather() {
        viewModelScope.launch {
            locationTracker.getCurrentLocation()?.let { location ->
                when (val result =
                    homeScreenContentUseCase.invoke(location.latitude, location.longitude)) {
                    is Resource.Success -> {
                        _uiState.update {
                            it.copy(
                                data = result.data,
                                isLoading = false,
                                errorMessage = null
                            )
                        }
                    }

                    is Resource.Error -> {
                        _uiState.update {
                            it.copy(
                                data = null,
                                isLoading = false,
                                errorMessage = result.message
                            )
                        }
                    }
                }
            } ?: kotlin.run {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = "Couldn't retrieve location. Make sure to grant permission and enable GPS."
                    )
                }
            }
        }
    }
}