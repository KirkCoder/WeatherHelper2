package com.weatherhelper

import com.weatherhelper.dto.ForecastDto
import com.weatherhelper.dto.WeatherListDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherNetworkSource {

    @GET("forecast")
    suspend fun getWeatherForecast(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
    ): ForecastDto

    @GET("weather")
    suspend fun getWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
    ): WeatherListDto
}