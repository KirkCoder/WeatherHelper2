package com.example.forecast.repository

import com.example.forecast.models.Forecasts
import kotlinx.coroutines.flow.Flow

interface ForecastRepository {
    suspend fun getForecast(lat: Double, lon: Double): Flow<Forecasts>
}
