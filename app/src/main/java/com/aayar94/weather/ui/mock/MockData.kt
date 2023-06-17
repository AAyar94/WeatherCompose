package com.aayar94.weather.ui.mock

import com.aayar94.weather.data.model.weather.Daily
import com.aayar94.weather.data.model.weather.FeelsLike
import com.aayar94.weather.data.model.weather.Hourly
import com.aayar94.weather.data.model.weather.Rain
import com.aayar94.weather.data.model.weather.Temp
import com.aayar94.weather.data.model.weather.Weather

val dailyList = listOf(
    Daily(
        clouds = 20,
        dew_point = 15.5,
        dt = 1652457600,
        feels_like = FeelsLike(24.7, 22.3, 19.5, 21.8),
        humidity = 75,
        moon_phase = 0.52,
        moonrise = 1652412480,
        moonset = 1652468280,
        pop = 0.15,
        pressure = 1012,
        rain = null,
        summary = "Partly cloudy",
        sunrise = 1652433840,
        sunset = 1652483760,
        temp = Temp(28.5, 31.2, 26.8, 29.5, morn = 18.8, night = 15.3),
        uvi = 6.3,
        weather = listOf(
            Weather("Partly cloudy", "02d", 801, "Clouds")
        ),
        wind_deg = 180,
        wind_gust = 8.2,
        wind_speed = 5.7
    ),
    Daily(
        clouds = 10,
        dew_point = 14.2,
        dt = 1652544000,
        feels_like = FeelsLike(24.0, 22.7, 19.2, 21.5),
        humidity = 68,
        moon_phase = 0.58,
        moonrise = 1652502960,
        moonset = 1652556720,
        pop = 0.1,
        pressure = 1011,
        rain = null,
        summary = "Sunny",
        sunrise = 1652510280,
        sunset = 1652560140,
        temp = Temp(29.8, 32.5, 28.1, 30.8, morn = 18.8, night = 15.3),
        uvi = 7.5,
        weather = listOf(
            Weather("Clear sky", "01d", 800, "Clear")
        ),
        wind_deg = 200,
        wind_gust = 7.8,
        wind_speed = 5.2
    ),
    Daily(
        clouds = 5,
        dew_point = 16.8,
        dt = 1652630400,
        feels_like = FeelsLike(25.9, 23.4, 20.8, 23.1),
        humidity = 72,
        moon_phase = 0.63,
        moonrise = 1652593440,
        moonset = 1652645040,
        pop = 0.05,
        pressure = 1010,
        rain = null,
        summary = "Mostly sunny",
        sunrise = 1652586720,
        sunset = 1652646480,
        temp = Temp(30.4, 33.1, 28.7, 31.4, morn = 18.8, night = 15.3),
        uvi = 8.2,
        weather = listOf(
            Weather("Mostly clear", "02d", 801, "Clouds")
        ),
        wind_deg = 220,
        wind_gust = 7.5,
        wind_speed = 4.9
    ),
    Daily(
        clouds = 40,
        dew_point = 17.6,
        dt = 1652716800,
        feels_like = FeelsLike(26.7, 24.3, 21.5, 23.8),
        humidity = 78,
        moon_phase = 0.68,
        moonrise = 1652683920,
        moonset = 1652733420,
        pop = 0.25,
        pressure = 1010,
        rain = null,
        summary = "Partly sunny",
        sunrise = 1652663160,
        sunset = 1652732820,
        temp = Temp(29.2, 31.9, 27.5, 30.2, morn = 18.8, night = 15.3),
        uvi = 6.8,
        weather = listOf(
            Weather("Partly cloudy", "02d", 801, "Clouds")
        ),
        wind_deg = 240,
        wind_gust = 6.8,
        wind_speed = 4.5
    ),
    Daily(
        clouds = 15,
        dew_point = 18.2,
        dt = 1652803200,
        feels_like = FeelsLike(27.6, 25.2, 22.4, 24.7),
        humidity = 80,
        moon_phase = 0.73,
        moonrise = 1652774400,
        moonset = 1652821800,
        pop = 0.1,
        pressure = 1011,
        rain = null,
        summary = "Sunny intervals",
        sunrise = 1652749600,
        sunset = 1652819160,
        temp = Temp(30.7, 33.4, 29.0, 31.7, morn = 18.8, night = 15.3),
        uvi = 7.3,
        weather = listOf(
            Weather("Partly cloudy", "02d", 801, "Clouds")
        ),
        wind_deg = 260,
        wind_gust = 6.4,
        wind_speed = 4.2
    ),
    Daily(
        clouds = 30,
        dew_point = 17.9,
        dt = 1652889600,
        feels_like = FeelsLike(26.9, 24.5, 21.7, 24.0),
        humidity = 76,
        moon_phase = 0.79,
        moonrise = 1652864880,
        moonset = 1652900340,
        pop = 0.2,
        pressure = 1012,
        rain = null,
        summary = "Intermittent clouds",
        sunrise = 1652836020,
        sunset = 1652905500,
        temp = Temp(28.0, 30.7, 26.3, 29.0, morn = 18.8, night = 15.3),
        uvi = 6.9,
        weather = listOf(
            Weather("Partly cloudy", "02d", 801, "Clouds")
        ),
        wind_deg = 280,
        wind_gust = 6.1,
        wind_speed = 3.9
    ),
    Daily(
        clouds = 50,
        dew_point = 16.5,
        dt = 1652976000,
        feels_like = FeelsLike(25.3, 22.9, 20.1, 22.4),
        humidity = 70,
        moon_phase = 0.84,
        moonrise = 1652955360,
        moonset = 1652988840,
        pop = 0.3,
        pressure = 1013,
        rain = null,
        summary = "Mostly cloudy",
        sunrise = 1652922440,
        sunset = 1652991840,
        temp = Temp(28.0, 30.7, 26.3, 29.0, morn = 18.8, night = 15.3),
        uvi = 6.1,
        weather = listOf(
            Weather("Cloudy", "03d", 802, "Clouds")
        ),
        wind_deg = 300,
        wind_gust = 5.7,
        wind_speed = 3.6
    ))

val hourlyList = listOf(
    Hourly(
        clouds = 20,
        dew_point = 15.5,
        dt = 1623463200,
        feels_like = 23.8,
        humidity = 65,
        pop = 0.1,
        pressure = 1015,
        rain = Rain(`1h` = 0.0),
        temp = 20.5,
        uvi = 5.2,
        visibility = 10000,
        weather = listOf(
            Weather(
                description = "Partly cloudy",
                icon = "02d",
                id = 801,
                main = "Clouds"
            )
        ),
        wind_deg = 180,
        wind_gust = 12.3,
        wind_speed = 8.5
    ),
    Hourly(
        clouds = 90,
        dew_point = 18.2,
        dt = 1623466800,
        feels_like = 22.1,
        humidity = 80,
        pop = 0.6,
        pressure = 1012,
        rain = Rain(`1h` = 1.8),
        temp = 19.2,
        uvi = 3.9,
        visibility = 5000,
        weather = listOf(
            Weather(
                description = "Light rain",
                icon = "10d",
                id = 500,
                main = "Rain"
            )
        ),
        wind_deg = 220,
        wind_gust = 10.2,
        wind_speed = 7.8
    ),
    Hourly(
        clouds = 20,
        dew_point = 15.5,
        dt = 1623463200,
        feels_like = 23.8,
        humidity = 65,
        pop = 0.1,
        pressure = 1015,
        rain = Rain(`1h` = 0.0),
        temp = 20.5,
        uvi = 5.2,
        visibility = 10000,
        weather = listOf(
            Weather(
                description = "Partly cloudy",
                icon = "02d",
                id = 801,
                main = "Clouds"
            )
        ),
        wind_deg = 180,
        wind_gust = 12.3,
        wind_speed = 8.5
    ),
    Hourly(
        clouds = 90,
        dew_point = 18.2,
        dt = 1623466800,
        feels_like = 22.1,
        humidity = 80,
        pop = 0.6,
        pressure = 1012,
        rain = Rain(`1h` = 1.8),
        temp = 19.2,
        uvi = 3.9,
        visibility = 5000,
        weather = listOf(
            Weather(
                description = "Light rain",
                icon = "10d",
                id = 500,
                main = "Rain"
            )
        ),
        wind_deg = 220,
        wind_gust = 10.2,
        wind_speed = 7.8
    ),
    Hourly(
        clouds = 20,
        dew_point = 15.5,
        dt = 1623463200,
        feels_like = 23.8,
        humidity = 65,
        pop = 0.1,
        pressure = 1015,
        rain = Rain(`1h` = 0.0),
        temp = 20.5,
        uvi = 5.2,
        visibility = 10000,
        weather = listOf(
            Weather(
                description = "Partly cloudy",
                icon = "02d",
                id = 801,
                main = "Clouds"
            )
        ),
        wind_deg = 180,
        wind_gust = 12.3,
        wind_speed = 8.5
    ),
    Hourly(
        clouds = 90,
        dew_point = 18.2,
        dt = 1623466800,
        feels_like = 22.1,
        humidity = 80,
        pop = 0.6,
        pressure = 1012,
        rain = Rain(`1h` = 1.8),
        temp = 19.2,
        uvi = 3.9,
        visibility = 5000,
        weather = listOf(
            Weather(
                description = "Light rain",
                icon = "10d",
                id = 500,
                main = "Rain"
            )
        ),
        wind_deg = 220,
        wind_gust = 10.2,
        wind_speed = 7.8
    ),
    Hourly(
        clouds = 20,
        dew_point = 15.5,
        dt = 1623463200,
        feels_like = 23.8,
        humidity = 65,
        pop = 0.1,
        pressure = 1015,
        rain = Rain(`1h` = 0.0),
        temp = 20.5,
        uvi = 5.2,
        visibility = 10000,
        weather = listOf(
            Weather(
                description = "Partly cloudy",
                icon = "02d",
                id = 801,
                main = "Clouds"
            )
        ),
        wind_deg = 180,
        wind_gust = 12.3,
        wind_speed = 8.5
    ),
    Hourly(
        clouds = 90,
        dew_point = 18.2,
        dt = 1623466800,
        feels_like = 22.1,
        humidity = 80,
        pop = 0.6,
        pressure = 1012,
        rain = Rain(`1h` = 1.8),
        temp = 19.2,
        uvi = 3.9,
        visibility = 5000,
        weather = listOf(
            Weather(
                description = "Light rain",
                icon = "10d",
                id = 500,
                main = "Rain"
            )
        ),
        wind_deg = 220,
        wind_gust = 10.2,
        wind_speed = 7.8
    ),
)
