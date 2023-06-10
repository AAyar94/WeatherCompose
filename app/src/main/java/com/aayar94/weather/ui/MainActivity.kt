package com.aayar94.weather.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.aayar94.weather.ui.theme.WeatherTheme

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
    Text(text = "Hello Weather App")
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    WeatherTheme {
        WeatherApp()
    }
}