package com.example.weatherhelper.mainweather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherhelper.mainlocationweather.GetMainLocationWeatherUseCase
import com.example.weatherhelper.mainlocationweather.models.MainLocationWeatherForecast
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainLocationWeatherViewModel @Inject constructor(
    private val getMainLocationWeatherUseCase: GetMainLocationWeatherUseCase,
) : ViewModel() {

    private val _forecastLiveData = MutableLiveData<MainLocationWeatherForecast>()

    val forecastLiveData: LiveData<MainLocationWeatherForecast>
        get() = _forecastLiveData

    init {
        viewModelScope.launch {
            try {
                getMainLocationWeatherUseCase.execute().collect { forecast ->
                    _forecastLiveData.value = forecast
                }
            } catch (t: Throwable) {
                t.printStackTrace()
            }
        }
    }
}
