package com.aayar94.weather.core.navigation

enum class WeatherScreens {
    Onboarding,
    Permission,
    HomeScreen,
    Humidity,
    Visibility,
    Wind,
    UltraViole,
    Sun,
    DetailScreen;

    companion object {
        fun fromRoute(route: String?): WeatherScreens = when (route?.substringBefore("/")) {
            Onboarding.name -> Onboarding
            Permission.name -> Permission
            HomeScreen.name -> HomeScreen
            Humidity.name -> Humidity
            Visibility.name -> Visibility
            Wind.name -> Wind
            UltraViole.name -> UltraViole
            Sun.name -> Sun
            DetailScreen.name -> DetailScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }

}