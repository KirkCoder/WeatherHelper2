package com.example.weatherhelper.mainweather.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherhelper.mainweather.databinding.MainLocationHoursWeatherBinding
import com.example.weatherhelper.mainweather.viewmodel.WeatherPresentation
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate

class MainLocationHoursWeatherDelegate: AdapterDelegate<List<WeatherPresentation>>() {
    override fun isForViewType(items: List<WeatherPresentation>, position: Int): Boolean {
        return items[position] is WeatherPresentation.HoursWeather
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val binding = MainLocationHoursWeatherBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MainLocationHoursWeatherViewHolder(binding)
    }

    override fun onBindViewHolder(
        items: List<WeatherPresentation>,
        position: Int,
        holder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>
    ) {
        (holder as MainLocationHoursWeatherViewHolder).bind(items[position] as WeatherPresentation.HoursWeather)
    }

}

class MainLocationHoursWeatherViewHolder(
    private val binding: MainLocationHoursWeatherBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(mainWeather: WeatherPresentation.HoursWeather) {
        binding.dt.text = mainWeather.dt
        binding.temperature.text = mainWeather.temp.toString()
        binding.weatherIcon.setImageResource(mainWeather.icon)
    }
}
