package com.aayar94.weather.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.aayar94.weather.core.navigation.WeatherNavigation
import com.aayar94.weather.core.theme.WeatherTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherTheme {
                WeatherApp()
            }
        }
    }
}

@Composable
fun WeatherApp() {
    WeatherNavigation()
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    WeatherTheme {
        WeatherApp()
    }
}