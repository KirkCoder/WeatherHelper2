package com.example.weatherhelper.mainlocationweather.models

import com.example.forecast.models.Forecasts

data class MainLocationWeatherForecast(
    val name: String,
    val forecasts: Forecasts,
)
