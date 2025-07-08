package com.example.mainlocation

import kotlinx.coroutines.flow.Flow

interface MainLocationStorage {
    fun getMainLocation(): Flow<MainLocationDao>
}
