package com.aayar94.weather.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ShowCurrentWeather(
    degree: Double,
    format: String,
    desc: String,
    highestDegree: Int,
    lowestDegree: Int,
    modifier: Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "$degree $format",
            textAlign = TextAlign.Center,
            fontSize = 72.sp,
            color = Color.White
        )
        Text(
            text = desc,
            textAlign = TextAlign.Center,
            fontSize = 36.sp,
            color = Color.White
        )
        Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(text = "H: $highestDegree", fontSize = 24.sp, color = Color.White)
            Spacer(modifier = modifier.width(12.dp))
            Text(text = "L: $lowestDegree", fontSize = 24.sp, color = Color.White)
        }
    }
}

@Preview
@Composable
fun ShowCurrentWeatherPreview() {
    ShowCurrentWeather(
        degree = 21.2,
        format = "°C",
        desc = "Bulutlu",
        highestDegree = 15,
        lowestDegree = 25,
        modifier = Modifier
    )
}