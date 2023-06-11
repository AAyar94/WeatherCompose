package com.aayar94.weather.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aayar94.weather.R
import com.aayar94.weather.ui.theme.WeatherTheme

@Composable
fun UvIndexCard(
    level: Int, desc: String,
) {
    MaterialDetailCard {
        Column(modifier = Modifier.padding(start = 12.dp, top = 12.dp)) {
            Row {
                Icon(
                    painter = painterResource(id = R.drawable.ic_ultraviolet),
                    contentDescription = "Ultraviolet Icon"
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(text = "UV-Index")
            }
            Text(text = level.toString(), fontSize = 48.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = desc, fontSize = 14.sp)
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_NO)
@Composable
fun DayUvIndexPreview() {
    WeatherTheme {
        UvIndexCard(4, "Moderate")
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun NightUvIndexPreview() {
    WeatherTheme {
        UvIndexCard(4, "Moderate")
    }
}