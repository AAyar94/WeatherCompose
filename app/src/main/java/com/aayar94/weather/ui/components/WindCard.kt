package com.aayar94.weather.ui.components

import android.content.res.Configuration
import android.graphics.Paint
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aayar94.weather.R
import com.aayar94.weather.core.theme.WeatherTheme
import java.lang.Math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun WindCard(
    windSpeed: Double,
    windDegree: Int,
    modifier: Modifier = Modifier,
) {
    MaterialDetailCard(Modifier.height(200.dp)) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp,
                top = 10.dp,
                bottom = 10.dp
            )
        ) {
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_wind),
                        contentDescription = "WindCard", modifier = Modifier.padding(end = 4.dp)
                    )
                    Text(
                        text = stringResource(R.string.wind),
                        style = MaterialTheme.typography.titleMedium
                    )
                }
                Text(
                    text = windSpeed.toString(),
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                )
                WindDirectionsVisualizer(
                    windDegree,
                    Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}

@Composable
fun WindDirectionsVisualizer(
    windDirection: Int,
    modifier: Modifier = Modifier,
) {
    var animate by remember { mutableStateOf(false) }
    val arrowAngle: Float by animateFloatAsState(
        targetValue = windDirection.toFloat() * -1,
        animationSpec = tween(
            durationMillis = if (animate) 1000 else 0,
            easing = FastOutSlowInEasing
        ), label = ""
    )
    val primaryColor = MaterialTheme.colorScheme.primary
    val ternaryColor = MaterialTheme.colorScheme.tertiary
    val northString = stringResource(R.string.north_char)
    val southString = stringResource(R.string.south_char)
    val eastString = stringResource(R.string.east_char)
    val westString = stringResource(R.string.west_char)
    Box(
        modifier = modifier
            .size(140.dp)
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_arrow_wind),
            contentDescription = stringResource(R.string.wind_direction),
            tint = primaryColor,
            modifier = Modifier
                .size(40.dp)
                .rotate(arrowAngle)
                .align(Alignment.Center)
        )
        val markersCount = 90
        for (i in 0..markersCount) {
            val angle = i * (360 / markersCount)
            Marker(
                angle = angle,
                drawMarker = i in listOf(0, 11, 22, 34, 45, 57, 68, 80),
                Modifier.align(Alignment.Center)
            )
        }
        Canvas(
            Modifier
                .size(130.dp)
                .align(Alignment.Center)
        ) {
            val canvasWidth = size.width
            val canvasHeight = size.height
            val paint = Paint()
            paint.textAlign = Paint.Align.CENTER
            paint.textSize = 24f
            paint.color = ternaryColor.toArgb()
            drawIntoCanvas { canvas ->
                canvas.nativeCanvas.apply {
                    drawText(northString, center.x, 80f, paint)
                    drawText(southString, center.x, canvasHeight - 60f, paint)
                    drawText(westString, 80f, center.y, paint)
                    drawText(eastString, canvasWidth - 80f, center.y, paint)
                }
            }

        }
    }
}

@Composable
internal fun Marker(
    angle: Int,
    drawMarker: Boolean,
    modifier: Modifier = Modifier,
) {
    val primaryColor = MaterialTheme.colorScheme.primary
    val ternaryColor = MaterialTheme.colorScheme.tertiary
    Box(
        modifier = Modifier
            .height(200.dp)
            .width(200.dp)
            .padding(14.dp)
            .drawBehind {
                val drawMarkerSize = if (drawMarker) 20f else 0f
                val theta = (angle - 90) * PI.toFloat() / 180f
                val startRadius = (size.width / 2 * .72f) + drawMarkerSize
                val endRadius = (size.width / 2 * .8f) - drawMarkerSize
                val startPos = Offset(cos(theta) * startRadius, sin(theta) * startRadius)
                val endPos = Offset(cos(theta) * endRadius, sin(theta) * endRadius)
                drawLine(
                    color = if (drawMarker) ternaryColor else primaryColor,
                    start = center + startPos,
                    end = center + endPos,
                    strokeWidth = if (drawMarker) 7f else 4f,
                    cap = StrokeCap.Round
                )
            }
    )
}


@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun WindCardPreview() {
    WeatherTheme {
        WindCard(
            windSpeed = 10.0,
            windDegree = 251
        )
    }
}