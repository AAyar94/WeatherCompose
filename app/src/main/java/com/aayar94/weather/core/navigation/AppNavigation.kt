package com.aayar94.weather.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aayar94.weather.presentation.home.HomeScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Route.HOME){
        composable(Route.HOME){
            HomeScreen(navController=navController)
        }
    }

}