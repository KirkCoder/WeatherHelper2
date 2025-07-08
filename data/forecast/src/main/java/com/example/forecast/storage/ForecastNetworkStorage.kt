package com.example.forecast.storage

import com.example.forecast.ForecastDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ForecastNetworkStorage {
    fun getForecast(lat: String, lon: String): Flow<ForecastDao> {
        return flow { ForecastDao("") }
    }
}
