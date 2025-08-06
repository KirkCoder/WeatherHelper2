package com.example.weatherhelper.mainweather.viewmodel

import androidx.annotation.DrawableRes

sealed class WeatherPresentation {
    data class Title(val locationName: String): WeatherPresentation()
    data class MainWeather(
        val temp: String,
        val feelsLike: String,
        val dt: String,
        val clouds: String,
        val wind: String,
        val rain: String,
        @DrawableRes
        val icon: Int,
        val description: String?,
    ): WeatherPresentation()

    data class DayWeather(
        val dayTemp: String,
        val nightTemp: String,
        val dt: String,
        val rain: String,
        @DrawableRes
        val icon: Int,
    ): WeatherPresentation()

    data class HoursWeather(
        val hoursWeather: List<HourWeather>,
    ): WeatherPresentation() {

        data class HourWeather(
            val temp: String,
            val dt: String,
            @DrawableRes
            val icon: Int,
        )
    }
}
