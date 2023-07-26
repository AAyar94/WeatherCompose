package com.aayar94.weather.common

import com.aayar94.weather.BuildConfig
import java.util.Locale

object Constant {
    const val BASE_URL = "https://api.openweathermap.org"
    val API_KEY = BuildConfig.WEATHER_API_KEY
    var SYSTEM_LANG_CODE = Locale.getDefault().toLanguageTag()
}