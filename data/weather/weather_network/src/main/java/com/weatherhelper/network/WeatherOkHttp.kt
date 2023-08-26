package com.weatherhelper.network

import okhttp3.OkHttpClient

interface WeatherOkHttp {
    val okHttpClient: OkHttpClient
}