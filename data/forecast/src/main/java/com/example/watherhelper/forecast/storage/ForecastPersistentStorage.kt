package com.example.watherhelper.forecast.storage

import com.example.watherhelper.forecast.ForecastDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ForecastPersistentStorage {
    fun getForecast(lat: String, lon: String): Flow<ForecastDao> {
        return flow { ForecastDao("") }
    }
}
