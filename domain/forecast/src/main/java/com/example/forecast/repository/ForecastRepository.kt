package com.example.forecast.repository

import com.example.forecast.models.WeatherForecast
import kotlinx.coroutines.flow.Flow

interface ForecastRepository {
    fun getForecast(lat: String, lon: String): Flow<WeatherForecast>
}
