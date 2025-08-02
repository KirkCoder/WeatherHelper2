package com.example.watherhelper.forecast.storage

import com.example.watherhelper.forecast.ForecastsDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ForecastNetworkStorage {
    @GET("/data/2.5/forecast?units=metric")
    suspend fun getForecast(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") appid: String
    ): ForecastsDto
}
