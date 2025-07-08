package com.example.mainlocation.repository

import com.example.mainlocation.MainLocationStorage
import com.example.mainlocation.mappers.toMainLocation
import com.example.mainlocationweather.models.MainLocation
import com.example.mainlocationweather.repository.MainLocationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MainLocationRepositoryImpl @Inject constructor(
    private val mainLocationStorage: MainLocationStorage
) : MainLocationRepository {
    override fun observeMainLocation(): Flow<MainLocation> {
        return mainLocationStorage.getMainLocation().map { dao ->
            dao.toMainLocation()
        }
    }
}
