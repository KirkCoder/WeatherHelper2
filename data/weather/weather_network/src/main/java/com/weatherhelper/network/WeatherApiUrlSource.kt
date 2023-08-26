package com.weatherhelper.network

import com.weatherhelper.BuildConfig
import javax.inject.Inject

internal class WeatherApiUrlSource @Inject constructor(){
    internal val weatherBaseUrl = BuildConfig.BACKEND_URL
}