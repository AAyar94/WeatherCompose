package com.aayar94.weather.ui.screens.home

import com.aayar94.weather.domain.model.HomeScreenDataModel

data class HomeUIState(
    val isLoading: Boolean = true,
    val errorMessage: String? = null,
    val homeScreenDataModel: HomeScreenDataModel? = null
)