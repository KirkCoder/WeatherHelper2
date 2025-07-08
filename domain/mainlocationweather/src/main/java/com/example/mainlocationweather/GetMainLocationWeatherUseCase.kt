package com.example.mainlocationweather

import com.example.forecast.repository.ForecastRepository
import com.example.mainlocationweather.models.MainLocationWeatherForecast
import com.example.mainlocationweather.repository.MainLocationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetMainLocationWeatherUseCase @Inject constructor(
    private val mainLocationRepository: MainLocationRepository,
    private val forecastRepository: ForecastRepository,
) {
    fun execute(): Flow<MainLocationWeatherForecast> {
        return mainLocationRepository.observeMainLocation().flatMapConcat { mainLocation ->
            forecastRepository.getForecast(mainLocation.lat, mainLocation.lon).map { forecast ->
                MainLocationWeatherForecast(
                    name = mainLocation.name,
                    forecast = forecast
                )
            }
        }
    }
}
