package com.aayar94.weather.ui.components

import android.content.res.Configuration
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
fun FellsLikeCard(
    degree: Int,
    actualDegree: Int,
) {
    MaterialDetailCard {

        Column(
            modifier = Modifier
                .height(200.dp)
                .width(200.dp)
                .padding(start = 12.dp, top = 12.dp)
        ) {
            Row {
                Icon(
                    painter = painterResource(id = R.drawable.ic_fells_like),
                    contentDescription = "Ultraviolet Icon"
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(text = "Fells Like")
            }
            Text(text = degree.toString(), fontSize = 48.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = differenceBetweenDegree(degree, actualDegree), fontSize = 14.sp)
        }

    }
}

fun differenceBetweenDegree(degree: Int, actualDegree: Int): String {
    val difference = degree - actualDegree
    return when (difference) {
        in 0..1 -> "Similar to actual degree"
        in 1..2 -> "Almost to actual degree"
        in 2..3 -> "A little bit different"
        else -> ""
    }
}


@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun FellsLikePreview() {
    WeatherTheme {
        FellsLikeCard(19, 18)
    }
}