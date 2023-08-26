package com.watherhelper

import com.weatherhelper.Dispatcher
import com.weatherhelper.WeatherHelperDispatchers
import com.weatherhelper.WeatherNetworkSource
import com.weatherhelper.dto.ForecastDto
import com.weatherhelper.dto.WeatherListDto
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class WeatherRepositoryImpl @Inject constructor(
    private val weatherNetworkSource: WeatherNetworkSource,
    @Dispatcher(WeatherHelperDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
) : WeatherRepository {

    override suspend fun getWeather(lat: Double, lon: Double): Pair<ForecastDto, WeatherListDto> {
        return withContext(ioDispatcher) {
            val forecast = async { weatherNetworkSource.getWeatherForecast(lat, lon) }
            val weather = async { weatherNetworkSource.getWeather(lat, lon) }
            forecast.await() to weather.await()
        }
    }
}