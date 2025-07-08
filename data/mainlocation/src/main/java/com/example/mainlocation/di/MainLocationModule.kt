package com.example.mainlocation.di

import com.example.mainlocation.MainLocationPersistentStorage
import com.example.mainlocation.MainLocationStorage
import com.example.mainlocation.repository.MainLocationRepositoryImpl
import com.example.mainlocationweather.repository.MainLocationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MainLocationModule {

    @Binds
    abstract fun getMainLocationStorage(mainLocationPersistentStorage: MainLocationPersistentStorage): MainLocationStorage

    @Binds
    abstract fun getMainLocationRepository(mainLocationRepository: MainLocationRepositoryImpl): MainLocationRepository
}
