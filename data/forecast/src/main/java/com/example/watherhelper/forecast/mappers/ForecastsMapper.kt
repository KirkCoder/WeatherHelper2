package com.example.watherhelper.forecast.mappers

import com.example.watherhelper.forecast.ForecastsDto
import com.example.forecast.models.Forecasts

internal fun ForecastsDto.toForecasts(): Forecasts {
    return Forecasts(this.cod + ", " + this.message + ", " + list.joinToString(", "))
}
