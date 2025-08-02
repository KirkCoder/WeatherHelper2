package com.example.weatherhelper.core.coroutines.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object DispatchersModule {
    @Provides
    @com.example.weatherhelper.core.coroutines.Dispatcher(com.example.weatherhelper.core.coroutines.WeatherHelperDispatchers.IO)
    fun providesIODispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @com.example.weatherhelper.core.coroutines.Dispatcher(com.example.weatherhelper.core.coroutines.WeatherHelperDispatchers.Default)
    fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default
}
