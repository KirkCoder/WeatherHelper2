package com.example.weatherhelper.mainlocationweather.models

import com.example.forecast.models.Forecast

data class MainLocationWeatherForecast(
    val name: String,
    val forecasts: List<Forecast>,
)
