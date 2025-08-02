package com.example.forecast.models

data class Forecast(
    val temp: Double,
    val feelsLike: Double,
    val dt: String,
    val clouds: Int,
    val windSpeed: Double,
    val rain: Double,
    val icon: Icon,
    val description: String?,
)

enum class Icon {
    CLEAR_SKY, FEW_CLOUDS, CLOUDS, RAINY, RAIN, THUNDERSTORM, SNOW, MIST
}
