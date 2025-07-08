package com.example.mainlocation

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MainLocationPersistentStorage @Inject constructor(): MainLocationStorage {

    override fun getMainLocation(): Flow<MainLocationDao> {
        return flow {
            MainLocationDao(
                lat = "51.5308",
                lon = "-0.1238",
                name = "London"
            )
        }
    }
}
