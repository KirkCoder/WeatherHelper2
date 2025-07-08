package com.example.mainlocationweather.models

import com.example.forecast.models.WeatherForecast

data class MainLocationWeatherForecast(
    val name: String,
    val forecast: WeatherForecast,
)
