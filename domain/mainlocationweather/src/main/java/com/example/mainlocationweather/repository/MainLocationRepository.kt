package com.example.mainlocationweather.repository

import com.example.mainlocationweather.models.MainLocation
import kotlinx.coroutines.flow.Flow

interface MainLocationRepository {
    fun observeMainLocation(): Flow<MainLocation>
}
