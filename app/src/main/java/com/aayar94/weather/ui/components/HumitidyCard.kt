package com.aayar94.weather.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aayar94.weather.R
import com.aayar94.weather.core.theme.WeatherTheme

@Composable
fun HumitidyCard(
    humitidy: Double,
    dewPoint: Double,
) {
    MaterialDetailCard {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(
                start = 8.dp,
                top = 8.dp,
                end = 8.dp,
                bottom = 8.dp
            )
        ) {
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_humidity),
                        contentDescription = stringResource(R.string.humitidycard),
                        modifier = Modifier.padding(end = 4.dp)
                    )
                    Text(
                        text = stringResource(R.string.humitidy),
                        style = MaterialTheme.typography.titleMedium
                    )
                }
                Text(text = humitidy.toString(), style = MaterialTheme.typography.titleLarge)
            }
            Text(
                text = "The dew point is ${dewPoint.toString()}",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}


@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun HumitidyCardPreview() {
    WeatherTheme {
        HumitidyCard(humitidy = 88.0, dewPoint = 22.0)
    }

}