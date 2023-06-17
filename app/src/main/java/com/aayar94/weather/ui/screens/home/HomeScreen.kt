package com.aayar94.weather.ui.screens.home

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.aayar94.weather.R
import com.aayar94.weather.ui.components.ShowCurrentWeather
import com.aayar94.weather.ui.components.TopBar

@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    val weatherResponse = homeViewModel.weatherResponse.collectAsState()
    val geolocationResponse = homeViewModel.geoLocationResponse.collectAsState()
    val formattedUnitFormat = when (homeViewModel.unit) {
        "metric" -> "°C"
        else -> "°F"
    }
    LaunchedEffect(key1 = Unit, block = {
        homeViewModel.getGeoLocation(39.578835, 32.143528)
        homeViewModel.getWeatherData(39.578835, 32.143528)
    })

    weatherResponse.let { weatherData ->
        geolocationResponse.let { geoLocationData ->

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
                    TopBar(
                        cityName = geoLocationData.value!![0].name,
                        modifier = Modifier.constrainAs(topBar) {
                            top.linkTo(parent.top, margin = 12.dp)
                            start.linkTo(parent.start, margin = 16.dp)
                            end.linkTo(parent.end, margin = 16.dp)
                        })

                    ShowCurrentWeather(degree = weatherData.value?.current?.temp!!,
                        format = formattedUnitFormat,
                        desc = weatherData.value!!.current.weather[0].description,
                        highestDegree = weatherData.value!!.daily[0].temp.min,
                        lowestDegree = weatherData.value!!.daily[0].temp.max,
                        modifier = Modifier.constrainAs(currentWeather) {
                            top.linkTo(topBar.bottom, margin = 8.dp)
                            start.linkTo(parent.start, margin = 16.dp)
                            end.linkTo(parent.end, margin = 16.dp)
                        })

                    Box(modifier = Modifier
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
                        })
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
                        .background(Color.Transparent)
                        .constrainAs(blurLayer) {
                            top.linkTo(bottomCard.top)
                            start.linkTo(bottomCard.start)
                            end.linkTo(bottomCard.end)
                            bottom.linkTo(parent.bottom)
                            width = Dimension.fillToConstraints
                        }) {
                        Column {
                            Row(modifier = Modifier.fillMaxWidth()) {
                                TabRow(selectedTabIndex = 0) {
                                    Tab(selected = true, onClick = { /*TODO*/ }) {
                                        Text(text = "Hourly")
                                    }
                                    Tab(selected = false, onClick = { /*TODO*/ }) {
                                        Text(text = "Daily")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


@Preview(showSystemUi = true, device = Devices.PIXEL_4_XL)
@Preview(showSystemUi = true, device = Devices.PIXEL_4_XL, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}