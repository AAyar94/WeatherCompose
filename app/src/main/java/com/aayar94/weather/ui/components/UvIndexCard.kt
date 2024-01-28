package com.aayar94.weather.ui.components

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
import com.aayar94.weather.core.theme.WeatherTheme

@Composable
fun UvIndexCard(
    level: Double, desc: String,
    modifier: Modifier = Modifier,
) {
    val localLevel = level.toInt()
    MaterialDetailCard {
        Column(
            modifier = Modifier
                .height(200.dp)
                .width(200.dp)
                .padding(start = 12.dp, top = 12.dp)
        ) {
            Row {
                Icon(
                    painter = painterResource(id = R.drawable.ic_ultraviolet),
                    contentDescription = "Ultraviolet Icon"
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(text = "UV-Index")
            }
            Text(text = localLevel.toString(), fontSize = 48.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = desc, fontSize = 14.sp)
        }
    }
}

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun UvIndexPreview() {
    WeatherTheme {
        UvIndexCard(4.0, "Moderate")
    }
}

fun uviToDescString(uvi: Double): String {
    val localUvi = uvi.toInt()
    return when (localUvi) {
        in 0..2 -> "Low"
        in 3..5 -> "Moderate"
        in 6..7 -> "High"
        in 8..10 -> "Very High"
        else -> "Extreme"

    }
}