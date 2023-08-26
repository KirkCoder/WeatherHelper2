package com.weatherhelper.dto

import dev.afanasev.kson.annotation.Kson

@Kson
data class ForecastDto(
    val cod: String?,
    val message: Long?,
    val cnt: Long?,
    val list: List<WeatherListDto>?,
    val city: CityDto?,
)

@Kson
data class CityDto(
    val id: Long?,
    val name: String?,
    val coord: CoordDto?,
    val country: String?,
    val population: Long?,
    val timezone: Long?,
    val sunrise: Long?,
    val sunset: Long?,
)