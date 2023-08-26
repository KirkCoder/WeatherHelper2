package com.weatherhelper.network

import com.weatherhelper.BuildConfig
import javax.inject.Inject

internal class WeatherApiKeySource @Inject constructor() {
    internal val apiKeyQueryValue = BuildConfig.API_KEY
    internal val apiKeyQuery = "appid"
}