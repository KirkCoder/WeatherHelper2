package com.example.weatherhelper.di.data

import com.example.weatherhelper.mainlocation.repository.MainLocationRepositoryImpl
import com.example.weatherhelper.mainlocationweather.repository.MainLocationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MainLocationModule {

    @Binds
    abstract fun getMainLocationRepository(mainLocationRepository: MainLocationRepositoryImpl): MainLocationRepository
}
