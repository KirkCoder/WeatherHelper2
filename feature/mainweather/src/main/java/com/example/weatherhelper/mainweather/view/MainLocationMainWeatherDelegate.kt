package com.example.weatherhelper.mainweather.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherhelper.mainweather.databinding.MainLocationMainWeatherBinding
import com.example.weatherhelper.mainweather.viewmodel.WeatherPresentation
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate

class MainLocationMainWeatherDelegate : AdapterDelegate<List<WeatherPresentation>>() {
    override fun isForViewType(items: List<WeatherPresentation>, position: Int): Boolean {
        return items[position] is WeatherPresentation.MainWeather
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val binding = MainLocationMainWeatherBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MainLocationMainWeatherViewHolder(binding)
    }

    override fun onBindViewHolder(
        items: List<WeatherPresentation>,
        position: Int,
        holder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>
    ) {
        (holder as MainLocationMainWeatherViewHolder).bind(items[position] as WeatherPresentation.MainWeather)
    }

}

class MainLocationMainWeatherViewHolder(
    private val binding: MainLocationMainWeatherBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(mainWeather: WeatherPresentation.MainWeather) {
        binding.feelsLike.text = mainWeather.feelsLike
        binding.temperature.text = mainWeather.temp
        binding.weatherIcon.setImageResource(mainWeather.icon)
        binding.description.text = mainWeather.description
        binding.wind.text = mainWeather.wind
        binding.clouds.text = mainWeather.clouds
        binding.rain.text = mainWeather.rain
    }
}
