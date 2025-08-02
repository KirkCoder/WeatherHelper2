package com.example.weatherhelper.mainweather.view

import com.example.weatherhelper.mainweather.viewmodel.WeatherPresentation
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class MainLocationWeatherAdapter : ListDelegationAdapter<List<WeatherPresentation>>() {

    init {
        delegatesManager.addDelegate(TitleDelegate())
            .addDelegate(MainLocationMainWeatherDelegate())
            .addDelegate(MainLocationHoursWeatherDelegate())
    }

    fun setData(list: List<WeatherPresentation>) {
        items = list
        notifyDataSetChanged()
    }
}
