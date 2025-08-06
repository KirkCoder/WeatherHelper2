package com.example.weatherhelper.mainweather.view

import com.example.weatherhelper.mainweather.viewmodel.WeatherPresentation
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class MainLocationHoursWeatherAdapter : ListDelegationAdapter<List<WeatherPresentation.HoursWeather.HourWeather>>() {

    init {
        delegatesManager.addDelegate(MainLocationHourWeatherDelegate())
    }

    fun setData(list: List<WeatherPresentation.HoursWeather.HourWeather>) {
        items = list
        notifyDataSetChanged()
    }
}
