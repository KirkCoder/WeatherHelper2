package com.example.weatherhelper.mainweather.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherhelper.mainweather.databinding.MainLocationHourWeatherBinding
import com.example.weatherhelper.mainweather.viewmodel.WeatherPresentation
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate

class MainLocationHourWeatherDelegate: AdapterDelegate<List<WeatherPresentation.HoursWeather.HourWeather>>() {

    override fun isForViewType(items: List<WeatherPresentation.HoursWeather.HourWeather>, position: Int): Boolean {
        return true
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val binding = MainLocationHourWeatherBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MainLocationHourWeatherViewHolder(binding)
    }

    override fun onBindViewHolder(
        items: List<WeatherPresentation.HoursWeather.HourWeather>,
        position: Int,
        holder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>
    ) {
        (holder as MainLocationHourWeatherViewHolder).bind(items[position])
    }

}

class MainLocationHourWeatherViewHolder(
    private val binding: MainLocationHourWeatherBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(mainWeather: WeatherPresentation.HoursWeather.HourWeather) {
        binding.dt.text = mainWeather.dt
        binding.temperature.text = mainWeather.temp
        binding.weatherIcon.setImageResource(mainWeather.icon)
    }
}
