package com.example.watherhelper.forecast.mappers

import com.example.forecast.models.Forecast
import com.example.watherhelper.forecast.ForecastsDto
import com.example.forecast.models.Icon

internal fun ForecastsDto.toForecasts(): List<Forecast> {
    return this.list.map { forecastDto ->
        Forecast(
            temp = forecastDto.main.temp,
            feelsLike = forecastDto.main.feelsLike,
            dt = forecastDto.dtTxt,
            clouds = forecastDto.clouds.all,
            windSpeed = forecastDto.wind.speed,
            rain = forecastDto.pop,
            icon = forecastDto.weather.firstOrNull()?.icon?.getIcon() ?: Icon.CLEAR_SKY,
            description = forecastDto.weather.firstOrNull()?.description
        )
    }
}
