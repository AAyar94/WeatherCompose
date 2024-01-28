package com.aayar94.weather.ui.screens.home

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.aayar94.weather.R
import com.aayar94.weather.ui.components.ShowCurrentWeather
import com.aayar94.weather.ui.components.TopBar
import com.aayar94.weather.core.navigation.WeatherScreens
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    LaunchedEffect(key1 = Unit) {
        homeViewModel.getLocationThenWeather()
    }
    val systemUIController = rememberSystemUiController()
    systemUIController.setStatusBarColor(Color.Black, false)
    val formattedUnitFormat = when (homeViewModel.unit) {
        "metric" -> "°C"
        else -> "°F"
    }
    val uiState = homeViewModel.uiState.collectAsState()
    if (uiState.value.homeScreenDataModel != null) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .paint(
                    painterResource(id = R.drawable.home_background),
                    contentScale = ContentScale.Crop
                )
        ) {
            Image(
                painter = painterResource(id = R.drawable.house_4_3),
                contentDescription = "House",
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .aspectRatio(3f / 4f)
                    .align(Alignment.BottomCenter)
            )

            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                TopBar(
                    cityName = uiState.value.homeScreenDataModel!!.geoLocationDto?.get(0)?.name
                        ?: "",
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(top = 12.dp)
                )

                ShowCurrentWeather(
                    degree = uiState.value.homeScreenDataModel!!.weatherDto?.current!!.temp,
                    format = formattedUnitFormat,
                    desc = uiState.value.homeScreenDataModel!!.weatherDto!!.current.weather[0].description,
                    highestDegree = uiState.value.homeScreenDataModel!!.weatherDto!!.daily[0].temp.min,
                    lowestDegree = uiState.value.homeScreenDataModel!!.weatherDto!!.daily[0].temp.max,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(top = 8.dp)
                )

                Spacer(modifier = Modifier.weight(1f))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(4 / 3f)
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color(0xFF46277C).copy(alpha = 0.75f),
                                    Color.Black,
                                    Color.Black
                                )
                            ),
                            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                        )
                ) {
                    Column {
                        Button(
                            onClick = {
                                navController.navigate(WeatherScreens.DetailScreen.name)
                            }, modifier = Modifier
                                .fillMaxWidth()
                                .align(CenterHorizontally)
                                .background(Color.Transparent)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_arrow_up),
                                contentDescription = "Details Button"
                            )
                        }
                        var selectedTabIndex by remember {
                            mutableIntStateOf(0)
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                        ) {
                            TabRow(
                                modifier = Modifier.padding(top = 10.dp),
                                selectedTabIndex = selectedTabIndex,
                                containerColor = Color.Transparent,
                                contentColor = Color.White,
                                indicator = { tabPositions ->
                                    TabRowDefaults.Indicator(
                                        modifier = Modifier.tabIndicatorOffset(
                                            tabPositions[selectedTabIndex]
                                        ),
                                        color = Color.White
                                    )
                                }
                            ) {
                                Tab(
                                    modifier = Modifier.padding(vertical = 10.dp),
                                    selected = selectedTabIndex == 0,
                                    onClick = {
                                        selectedTabIndex = 0
                                    }
                                ) {
                                    Text(text = "Hourly")
                                }
                                Tab(
                                    modifier = Modifier.padding(vertical = 10.dp),
                                    selected = selectedTabIndex == 1,
                                    onClick = {
                                        selectedTabIndex = 1
                                    }
                                ) {
                                    Text(text = "Daily")
                                }
                            }
                        }
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.Transparent),
                            contentAlignment = Alignment.Center
                        ) {
                            if (selectedTabIndex == 0) {
                                Text(
                                    text = "Hourly",
                                    color = Color.White
                                )
                            } else {
                                Text(
                                    text = "Daily",
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }
        }
    } else {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Center) {
            CircularProgressIndicator()
        }
    }
}


@Preview(showSystemUi = true, device = Devices.PIXEL_4_XL)
@Preview(showSystemUi = true, device = Devices.PIXEL_4_XL, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}