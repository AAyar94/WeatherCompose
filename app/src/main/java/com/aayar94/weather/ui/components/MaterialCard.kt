package com.aayar94.weather.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aayar94.weather.ui.theme.WeatherTheme

@Composable
fun MaterialDetailCard(
    modifier: Modifier = Modifier,
    shape: RoundedCornerShape = RoundedCornerShape(size = 24.dp),
    color: Color = MaterialTheme.colorScheme.secondaryContainer,
    content: @Composable () -> Unit,
) {
    Surface(
        modifier = modifier
            .fillMaxWidth().height(150.dp),
        shape = shape,
        color = color,
        content = content
    )
}

@Preview(uiMode = UI_MODE_NIGHT_NO)
@Composable
fun DayMaterialDetailCardPreview() {
    WeatherTheme {
        MaterialDetailCard {
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun NightMaterialDetailCardPreview() {
    WeatherTheme {
        MaterialDetailCard {
        }
    }
}