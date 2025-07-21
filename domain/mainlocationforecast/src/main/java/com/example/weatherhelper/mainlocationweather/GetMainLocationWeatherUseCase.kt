package com.example.weatherhelper.mainlocationweather

import com.example.forecast.repository.ForecastRepository
import com.example.weatherhelper.mainlocationweather.models.MainLocationWeatherForecast
import com.example.weatherhelper.mainlocationweather.repository.MainLocationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetMainLocationWeatherUseCase @Inject constructor(
    private val mainLocationRepository: MainLocationRepository,
    private val forecastRepository: ForecastRepository,
) {
    suspend fun execute(): Flow<MainLocationWeatherForecast> {
        return mainLocationRepository.observeMainLocation().flatMapConcat { mainLocation ->
            forecastRepository.getForecast(mainLocation.lat, mainLocation.lon).map { forecasts ->
                MainLocationWeatherForecast(
                    name = mainLocation.name,
                    forecasts = forecasts
                )
            }
        }
    }
}
