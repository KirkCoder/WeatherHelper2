package com.example.weatherhelper.mainlocation.repository

import com.example.weatherhelper.mainlocation.MainLocationPersistentStorage
import com.example.weatherhelper.mainlocation.mappers.toMainLocation
import com.example.weatherhelper.mainlocationweather.models.MainLocation
import com.example.weatherhelper.mainlocationweather.repository.MainLocationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MainLocationRepositoryImpl @Inject constructor(
    private val mainLocationStorage: MainLocationPersistentStorage,
) : MainLocationRepository {
    override suspend fun observeMainLocation(): Flow<MainLocation> {
        return mainLocationStorage.getMainLocation().map { dao ->
            dao.toMainLocation()
        }
    }
}
