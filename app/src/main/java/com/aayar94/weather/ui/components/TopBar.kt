package com.aayar94.weather.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aayar94.weather.R

@Composable
fun TopBar(cityName: String, modifier: Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 25.dp, vertical = 15.dp),
    ) {
        IconButton(modifier = modifier.weight(1f),
            onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.Refresh,
                contentDescription = stringResource(R.string.refresh_weather),
                tint = Color.White
            )
        }
        Text(
            text = cityName,
            modifier = modifier
                .weight(3f)
                .padding(top = 8.dp),
            color = Color.White,
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )
        IconButton(modifier = modifier.weight(1f), onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = stringResource(R.string.location),
                tint = Color.White
            )
        }
    }
}

@Preview
@Composable
fun TopBarPreview() {
    //TopBar(cityName = "Polatlı")
}