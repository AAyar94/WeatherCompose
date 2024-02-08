package com.aayar94.weather.presentation.home

import com.aayar94.weather.domain.model.HomeScreenContent

data class HomeUiState(
    val isLoading: Boolean = true,
    val errorMessage: String? = null,
    val data: HomeScreenContent? = null
)