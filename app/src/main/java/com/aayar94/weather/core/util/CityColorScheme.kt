package com.aayar94.weather.core.util

import androidx.compose.ui.graphics.Color
import com.aayar94.weather.R
import com.aayar94.weather.core.theme.greenScheme
import com.aayar94.weather.core.theme.orangeScheme
import com.aayar94.weather.core.theme.redScheme

data class CityColorScheme(
    val rawBgImage: Int,
    val primaryColor: Color,
)

object CityColorSchemes {
    val list = listOf(
        CityColorScheme(R.drawable.green_scheme, primaryColor = greenScheme),
        CityColorScheme(R.drawable.yellow_scheme, primaryColor = orangeScheme),
        CityColorScheme(R.drawable.red_scheme, primaryColor = redScheme)
    )
}