package com.example.weatherhelper.mainweather.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherhelper.mainweather.databinding.MainLocationDailyWeatherBinding
import com.example.weatherhelper.mainweather.viewmodel.WeatherPresentation
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate

class MainLocationDailyWeatherDelegate: AdapterDelegate<List<WeatherPresentation>>() {

    override fun isForViewType(items: List<WeatherPresentation>, position: Int): Boolean {
        return items[position] is WeatherPresentation.DayWeather
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val binding = MainLocationDailyWeatherBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MainLocationDailyWeatherViewHolder(binding)
    }

    override fun onBindViewHolder(
        items: List<WeatherPresentation>,
        position: Int,
        holder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>
    ) {
        (holder as MainLocationDailyWeatherViewHolder).bind(items[position] as WeatherPresentation.DayWeather)
    }

}

class MainLocationDailyWeatherViewHolder(
    private val binding: MainLocationDailyWeatherBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(mainWeather: WeatherPresentation.DayWeather) {
        binding.dt.text = mainWeather.dt
        binding.nightTemp.text = mainWeather.nightTemp
        binding.dayTemp.text = mainWeather.dayTemp
        binding.weatherIcon.setImageResource(mainWeather.icon)
    }
}

