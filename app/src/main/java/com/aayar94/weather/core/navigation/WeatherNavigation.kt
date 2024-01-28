package com.aayar94.weather.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aayar94.weather.ui.screens.DetailsScreen
import com.aayar94.weather.ui.screens.home.HomeScreen

@Composable
fun WeatherNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = WeatherScreens.HomeScreen.name,
        builder = {
            composable(WeatherScreens.HomeScreen.name) {
                HomeScreen(navController = navController)
            }

            composable(WeatherScreens.DetailScreen.name) {
                DetailsScreen(navController = navController)
            }
        })
}