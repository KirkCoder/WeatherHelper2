package com.example.weatherhelper.di.data

import com.example.forecast.repository.ForecastRepository
import com.example.watherhelper.forecast.repository.ForecastRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ForecastModule {
    @Binds
    abstract fun getForecastRepository(forecastRepository: ForecastRepositoryImpl): ForecastRepository
}
