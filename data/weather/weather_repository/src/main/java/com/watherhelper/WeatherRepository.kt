package com.watherhelper

import com.weatherhelper.dto.ForecastDto
import com.weatherhelper.dto.WeatherListDto

interface WeatherRepository {
    suspend fun getWeather(lat: Double, lon: Double): Pair<ForecastDto, WeatherListDto>
}