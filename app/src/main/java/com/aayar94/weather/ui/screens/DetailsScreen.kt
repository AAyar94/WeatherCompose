package com.aayar94.weather.ui.screens

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.aayar94.weather.ui.components.FellsLikeCard
import com.aayar94.weather.ui.components.HumitidyCard
import com.aayar94.weather.ui.components.UvIndexCard
import com.aayar94.weather.ui.components.WindCard
import com.aayar94.weather.ui.components.uviToDescString
import com.aayar94.weather.ui.mock.MockWeatherDataModel
import com.aayar94.weather.ui.theme.WeatherTheme

@Composable
fun DetailsScreen(navController: NavController) {
    DetailScreenContent()

}

@Composable
fun DetailScreenContent(
) {
    val weatherData = MockWeatherDataModel
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {
        Column(Modifier.fillMaxSize()) {
            Row(modifier = Modifier.fillMaxWidth()) {
                UvIndexCard(
                    level = weatherData.current.uvi.toDouble(),
                    desc = uviToDescString(weatherData.current.uvi.toDouble()),
                    modifier = Modifier.width(200.dp)
                )
                WindCard(
                    windSpeed = weatherData.current.wind_speed,
                    windDegree = weatherData.current.wind_deg,
                    modifier = Modifier.width(200.dp)
                )
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                HumitidyCard(
                    humitidy = weatherData.current.humidity.toDouble(),
                    dewPoint = weatherData.current.dew_point
                )
                FellsLikeCard(
                    degree = weatherData.current.feels_like.toInt(),
                    actualDegree = weatherData.current.temp.toInt()
                )
            }
        }
    }
}

@Preview(showSystemUi = true, device = Devices.PIXEL_4_XL)
@Preview(showSystemUi = true, device = Devices.PIXEL_4_XL, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DetailScreenPreview() {
    WeatherTheme {
        DetailsScreen(navController = rememberNavController())
    }
}
