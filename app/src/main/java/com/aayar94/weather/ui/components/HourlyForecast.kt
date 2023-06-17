package com.aayar94.weather.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aayar94.weather.R
import com.aayar94.weather.data.model.weather.Hourly
import com.aayar94.weather.ui.mock.hourlyList
import com.aayar94.weather.ui.theme.WeatherTheme

@Composable
fun HourlyForecast(
    hourlyDataList: List<Hourly>,
    modifier: Modifier = Modifier,
) {

}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun WeatherLocationPreview() {
    WeatherTheme {
        HourlyForecast(hourlyList)
    }
}
