package com.example.weatherhelper.mainweather.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherhelper.core.coroutines.Dispatcher
import com.example.weatherhelper.core.coroutines.WeatherHelperDispatchers
import com.example.weatherhelper.mainlocationweather.GetMainLocationWeatherUseCase
import com.example.weatherhelper.mainweather.mappers.map
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainLocationWeatherViewModel @Inject constructor(
    private val getMainLocationWeatherUseCase: GetMainLocationWeatherUseCase,
    private val application: Application,
    @Dispatcher(WeatherHelperDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
) : ViewModel() {

    private val _forecastLiveData = MutableLiveData<List<WeatherPresentation>>()

    val forecastLiveData: LiveData<List<WeatherPresentation>>
        get() = _forecastLiveData

    private var refreshJob: Job? = null

    init {
        update()
    }

    fun update() {
        refreshJob?.cancel()

        refreshJob = viewModelScope.launch {
            try {
                getMainLocationWeatherUseCase.execute()
                    .map { locationWithForecast ->
                        locationWithForecast.map(application)
                    }
                    .flowOn(ioDispatcher)
                    .collect { forecast ->
                        _forecastLiveData.value = forecast
                    }
            } catch (t: Throwable) {
                t.printStackTrace()
            }
        }
    }
}
