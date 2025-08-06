package com.example.watherhelper.forecast.repository

import androidx.tracing.trace
import com.example.forecast.models.Forecast
import com.example.watherhelper.forecast.mappers.toForecasts
import com.example.forecast.repository.ForecastRepository
import com.example.watherhelper.forecast.storage.ForecastNetworkStorage
import com.example.watherhelper.forecast.BuildConfig
import com.example.weatherhelper.core.coroutines.Dispatcher
import com.example.weatherhelper.core.coroutines.WeatherHelperDispatchers
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Retrofit
import javax.inject.Inject

class ForecastRepositoryImpl @Inject constructor(
    private val retrofit: Retrofit,
    @Dispatcher(WeatherHelperDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
) : ForecastRepository {

    private val forecastApi = trace("ForecastNetwork") {
        retrofit.create(ForecastNetworkStorage::class.java)
    }

    override suspend fun getForecast(lat: Double, lon: Double): Flow<List<Forecast>> {
        return flow {
            emit(
                forecastApi.getForecast(lat, lon, BuildConfig.API_KEY).toForecasts()
            )
        }.flowOn(ioDispatcher)
    }
}
