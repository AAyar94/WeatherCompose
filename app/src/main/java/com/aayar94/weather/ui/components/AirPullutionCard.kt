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
fun AirPullutionCard(
    level: Int,
    desc: String,
) {
    MaterialDetailCard {
        Column(modifier = Modifier.padding(start = 12.dp, top = 8.dp)) {
            Row() {
                Icon(
                    painter = painterResource(id = R.drawable.ic_air_quality),
                    contentDescription = "Air pollution icon"
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(text = "Air Pullution")
            }
            Spacer(modifier = Modifier.height(14.dp))
            Row(modifier = Modifier.padding(start = 12.dp)) {
                Text(text = level.toString(), fontSize = 20.sp)
                Spacer(modifier = Modifier.width(24.dp))
                Text(text = desc)
            }

        }
    }
}


@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun AirPullutionCardPreview() {
    WeatherTheme {
        AirPullutionCard(
            4, "Moderate"
        )
    }
}
