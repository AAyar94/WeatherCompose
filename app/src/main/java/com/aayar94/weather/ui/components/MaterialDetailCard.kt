package com.aayar94.weather.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
    color: Color = MaterialTheme.colorScheme.primaryContainer,
    content: @Composable () -> Unit,
) {
    Surface(
        modifier = modifier
            .width(200.dp)
            .height(200.dp)
            .padding(12.dp),
        shape = shape,
        color = color,
        content = content
    )
}

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun MaterialDetailCardPreview() {
    WeatherTheme {
        MaterialDetailCard {
        }
    }
}