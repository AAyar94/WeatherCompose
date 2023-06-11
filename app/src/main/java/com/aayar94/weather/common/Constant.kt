package com.aayar94.weather.common

import com.aayar94.weather.BuildConfig
import java.util.Locale

class Constant {
    companion object {


        const val BASE_URL = "https://api.openweathermap.org"

        var SYSTEM_LANG_CODE = Locale.getDefault().toLanguageTag()

        const val API_KEY = BuildConfig.WEATHER_API_KEY
    }

}