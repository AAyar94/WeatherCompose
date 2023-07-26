package com.aayar94.weather.ui.mock

import com.aayar94.weather.data.model.weather.Current
import com.aayar94.weather.data.model.weather.Daily
import com.aayar94.weather.data.model.weather.FeelsLike
import com.aayar94.weather.data.model.weather.Hourly
import com.aayar94.weather.data.model.weather.Rain
import com.aayar94.weather.data.model.weather.Temp
import com.aayar94.weather.data.model.weather.Weather
import com.aayar94.weather.data.model.weather.WeatherDataModel

val MockWeatherDataModel = WeatherDataModel(
    lat = 39.5788,
    lon = 32.1435,
    timezone = "Europe/Istanbul",
    timezone_offset = 10800,
    current = Current(
        dt = 1687026809,
        sunrise = 1686968610,
        sunset = 1687022461,
        temp = 17.73,
        feels_like = 17.33,
        pressure = 1005,
        humidity = 68,
        dew_point = 11.75,
        uvi = 0.0,
        clouds = 34,
        visibility = 10000,
        wind_speed = 4.4,
        wind_deg = 289,
        wind_gust = 9.12,
        weather = List<Weather>(1) {
            Weather(
                id = 500,
                main = "Rain",
                description = "Light Rain",
                icon = "10n"
            )
        },

        ),
    hourly = hourlyListCreator(),
    daily = dailyDataList()
)

fun hourlyListCreator(): MutableList<Hourly> {
    val hourlyList = mutableListOf<Hourly>()
    repeat(5) {
        val clouds = (0..100).random()
        val dewPoint = (0..30).random().toDouble()
        val dt = (0..999999999).random()
        val feelsLike = (-10..40).random().toDouble()
        val humidity = (0..100).random()
        val pop = (0..100).random().toDouble() / 100
        val pressure = (900..1100).random()
        val rain = Rain((0..10).random().toDouble())
        val temp = (-10..40).random().toDouble()
        val uvi = (0..10).random().toDouble()
        val visibility = (0..10000).random()
        val weather = listOf(
            Weather("Mock description", "mock_icon", (200..800).random(), "Mock main")
        )
        val windDeg = (0..360).random()
        val windGust = (0..50).random().toDouble()
        val windSpeed = (0..20).random().toDouble()

        val hourly = Hourly(
            clouds,
            dewPoint,
            dt,
            feelsLike,
            humidity,
            pop,
            pressure,
            rain,
            temp,
            uvi,
            visibility,
            weather,
            windDeg,
            windGust,
            windSpeed
        )

        hourlyList.add(hourly)
    }

    return hourlyList
}

fun dailyDataList(): MutableList<Daily> {
    val dailyList = mutableListOf<Daily>()


    val day1 = Daily(
        clouds = 40,
        dew_point = 15.5,
        dt = 1654321200,
        feels_like = FeelsLike(25.7, 22.3, 18.9, 20.1),
        humidity = 70,
        moon_phase = 0.75,
        moonrise = 1654321800,
        moonset = 1654355400,
        pop = 0.15,
        pressure = 1016,
        rain = null,
        summary = "Partly cloudy",
        sunrise = 1654315800,
        sunset = 1654366200,
        temp = Temp(28.5, 30.2, 23.8, 26.7, 19.2, 20.9),
        uvi = 8.2,
        weather = listOf(
            Weather("Partly cloudy", "03d", 801, "Clouds"),
            Weather("Sunny", "01d", 800, "Clear")
        ),
        wind_deg = 220,
        wind_gust = 12.5,
        wind_speed = 8.3
    )
    val day2 = Daily(
        clouds = 10,
        dew_point = 18.2,
        dt = 1654407600,
        feels_like = FeelsLike(27.9, 25.1, 20.3, 22.7),
        humidity = 62,
        moon_phase = 0.25,
        moonrise = 1654404600,
        moonset = 1654448400,
        pop = 0.05,
        pressure = 1015,
        rain = null,
        summary = "Clear sky",
        sunrise = 1654392000,
        sunset = 1654442400,
        temp = Temp(32.8, 34.7, 28.1, 30.5, 19.2, 20.9),
        uvi = 9.6,
        weather = listOf(
            Weather("Clear sky", "01d", 800, "Clear")
        ),
        wind_deg = 180,
        wind_gust = 9.8,
        wind_speed = 6.5
    )
    val day3 = Daily(
        clouds = 90,
        dew_point = 22.6,
        dt = 1654494000,
        feels_like = FeelsLike(30.1, 28.9, 25.2, 26.7),
        humidity = 80,
        moon_phase = 0.9,
        moonrise = 1654499400,
        moonset = 1654541400,
        pop = 0.35,
        pressure = 1013,
        rain = 3.2,
        summary = "Light rain showers",
        sunrise = 1654488200,
        sunset = 1654538600,
        temp = Temp(25.7, 27.4, 22.1, 23.9, 19.2, 20.9),
        uvi = 5.3,
        weather = listOf(
            Weather("Light rain showers", "09d", 500, "Rain")
        ),
        wind_deg = 300,
        wind_gust = 14.2,
        wind_speed = 10.6
    )
    val day4 = Daily(
        clouds = 80,
        dew_point = 16.9,
        dt = 1654580400,
        feels_like = FeelsLike(24.8, 22.4, 19.7, 21.1),
        humidity = 68,
        moon_phase = 0.4,
        moonrise = 1654582800,
        moonset = 1654624800,
        pop = 0.6,
        pressure = 1012,
        rain = 8.1,
        summary = "Showers",
        sunrise = 1654564400,
        sunset = 1654614800,
        temp = Temp(23.5, 25.1, 19.9, 21.8, 19.2, 20.9),
        uvi = 4.1,
        weather = listOf(
            Weather("Showers", "09d", 501, "Rain")
        ),
        wind_deg = 250,
        wind_gust = 11.9,
        wind_speed = 7.8
    )
    val day5 = Daily(
        clouds = 100,
        dew_point = 20.3,
        dt = 1654666800,
        feels_like = FeelsLike(28.6, 26.2, 22.7, 24.9),
        humidity = 75,
        moon_phase = 0.1,
        moonrise = 1654665600,
        moonset = 1654708200,
        pop = 0.9,
        pressure = 1010,
        rain = 12.5,
        summary = "Heavy rain",
        sunrise = 1654650600,
        sunset = 1654697000,
        temp = Temp(21.8, 23.4, 19.2, 20.9, 19.2, 20.9),
        uvi = 2.8,
        weather = listOf(
            Weather("Heavy rain", "10d", 502, "Rain")
        ),
        wind_deg = 280,
        wind_gust = 16.5,
        wind_speed = 12.3
    )

    dailyList.add(day1)
    dailyList.add(day2)
    dailyList.add(day3)
    dailyList.add(day4)
    dailyList.add(day5)
    return dailyList
}



