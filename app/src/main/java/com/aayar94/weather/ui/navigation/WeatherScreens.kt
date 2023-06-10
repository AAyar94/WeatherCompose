package com.aayar94.weather.ui.navigation

enum class WeatherScreens {
    HomeScreen,
    DetailScreen;

    companion object {
        fun fromRoute(route: String?): WeatherScreens = when (route?.substringBefore("/")) {
            HomeScreen.name -> HomeScreen
            DetailScreen.name -> DetailScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }

}