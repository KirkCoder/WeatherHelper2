package com.example.weatherhelper.mainlocationweather.repository

import com.example.weatherhelper.mainlocationweather.models.MainLocation
import kotlinx.coroutines.flow.Flow

interface MainLocationRepository {
    suspend fun observeMainLocation(): Flow<MainLocation>
}
