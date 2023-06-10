package com.aayar94.weather.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.aayar94.weather.R
import com.aayar94.weather.ui.components.ShowCurrentWeather
import com.aayar94.weather.ui.components.TopBar

@Composable
fun HomeScreen(navController: NavController) {
    val cityName = "Polatlı"
    val degree = 22.2
    val format = "°C"
    val desc = "Bulutlu"
    val highestDegree = 15
    val lowestDegree = 25
    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.home_background),
                contentScale = ContentScale.FillBounds
            )
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (topBar, currentWeather, houseImage, bottomCard, blurLayer) = createRefs()
            TopBar(cityName = cityName, modifier = Modifier
                .constrainAs(topBar) {
                    top.linkTo(parent.top, margin = 24.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                })
            ShowCurrentWeather(
                degree = degree,
                format = format,
                desc = desc,
                highestDegree = highestDegree,
                lowestDegree = lowestDegree,
                modifier = Modifier.constrainAs(currentWeather) {
                    top.linkTo(topBar.bottom, margin = 8.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                }
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .paint(
                        painterResource(id = R.drawable.house_4_3),
                        contentScale = ContentScale.FillBounds
                    )
                    .constrainAs(houseImage) {
                        top.linkTo(currentWeather.bottom, margin = 8.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                        width = Dimension.fillToConstraints
                    }
            )
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Blue)
                    .constrainAs(bottomCard) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    }, shape = RoundedCornerShape(size = 20.dp)
            ) {}
            Box(modifier = Modifier
                .blur(radius = 20.dp)
                .constrainAs(blurLayer) {
                    top.linkTo(bottomCard.top)
                    start.linkTo(bottomCard.start)
                    end.linkTo(bottomCard.end)
                    bottom.linkTo(parent.bottom)
                    width = Dimension.fillToConstraints
                }) {

            }

        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}