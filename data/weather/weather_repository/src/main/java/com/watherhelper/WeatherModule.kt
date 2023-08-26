package com.watherhelper

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface WeatherModule {

    @Binds
    fun provideWeatherRepository(repository: WeatherRepositoryImpl): WeatherRepository
}