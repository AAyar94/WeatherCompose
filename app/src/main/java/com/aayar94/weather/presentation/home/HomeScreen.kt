package com.aayar94.weather.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.aayar94.weather.R
import com.aayar94.weather.core.theme.LocalSpacing
import com.aayar94.weather.core.util.CityColorSchemes
import com.aayar94.weather.core.util.DevicesPreview

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    val colorScheme = CityColorSchemes.list.random()
    val state = rememberLazyListState()
    val uiState = viewModel.uiState.collectAsState()
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = colorScheme.rawBgImage),
            contentDescription = null
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = spacing.spaceLarge)
                .zIndex(2f),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(2f))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = uiState.value.data?.cityName ?: "",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontSize = 48.sp
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = uiState.value.data?.degree.toString(),
                        fontSize = 36.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center, modifier = Modifier.alignBy(LastBaseline)
                    )
                    Text(
                        text = "C",
                        fontSize = 18.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center, modifier = Modifier.alignBy(LastBaseline)
                    )
                }
                Text(
                    text = uiState.value.data?.date ?: "", fontSize = 24.sp, color = Color.White,
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.weight(1f))
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = spacing.spaceLarge),
                    shape = RoundedCornerShape(20.dp),
                    color = Color.White
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(spacing.spaceMedium),
                        shape = RoundedCornerShape(20.dp),
                        colors = CardDefaults.cardColors(containerColor = colorScheme.primaryColor),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(
                                modifier = Modifier.padding(spacing.spaceSmall),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Row() {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_ultraviolet),
                                        contentDescription = null, tint = Color.White
                                    )
                                    Spacer(modifier = Modifier.width(spacing.spaceSmall))
                                    Text(
                                        text = stringResource(R.string.ultraviyolet),
                                        color = Color.White,
                                        fontSize = 14.sp
                                    )
                                }
                                Spacer(modifier = Modifier.height(spacing.spaceMedium))
                                Text(text = "degree", fontSize = 16.sp, color = Color.White)
                            }
                            Divider(
                                color = Color.Gray,
                                modifier = Modifier
                                    .height(200.dp)
                                    .width(2.dp)
                            )
                            Column(
                                modifier = Modifier.padding(spacing.spaceSmall),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Row() {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_wind),
                                        contentDescription = null, tint = Color.White
                                    )
                                    Spacer(modifier = Modifier.width(spacing.spaceSmall))
                                    Text(
                                        text = stringResource(R.string.wind_speed),
                                        color = Color.White,
                                        maxLines = 2,
                                        fontSize = 14.sp
                                    )
                                }
                                Spacer(modifier = Modifier.height(spacing.spaceMedium))
                                Text(text = "degree", fontSize = 16.sp, color = Color.White)
                            }
                            Divider(
                                color = Color.Gray,
                                modifier = Modifier
                                    .height(200.dp)
                                    .width(2.dp)
                            )
                            Column(
                                modifier = Modifier.padding(spacing.spaceSmall),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Row() {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_humidity),
                                        contentDescription = null, tint = Color.White
                                    )
                                    Spacer(modifier = Modifier.width(spacing.spaceSmall))
                                    Text(
                                        text = stringResource(R.string.humidity),
                                        color = Color.White,
                                        fontSize = 14.sp, maxLines = 1
                                    )
                                }
                                Spacer(modifier = Modifier.height(spacing.spaceMedium))
                                Text(text = "degree", fontSize = 16.sp, color = Color.White)
                            }
                        }
                    }

                }
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = spacing.spaceLarge),
                    shape = RoundedCornerShape(20.dp),
                    color = Color.White
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(spacing.spaceMedium),
                        shape = RoundedCornerShape(20.dp),
                        colors = CardDefaults.cardColors(containerColor = colorScheme.primaryColor),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        LazyRow(modifier = Modifier, state = state) {
                            //items(uiState.value.data)
                        }
                    }
                }
            }
        }
    }
}


@DevicesPreview
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}