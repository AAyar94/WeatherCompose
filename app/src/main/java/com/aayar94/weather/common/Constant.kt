package com.aayar94.weather.common

import android.annotation.SuppressLint
import java.util.Locale

class Constant {
    companion object{
        val BASE_URL = "https://api.openweathermap.org"

        val SYSTEM_LANG_CODE = Locale.getDefault().toLanguageTag()
    }
}