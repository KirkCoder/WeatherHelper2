package com.example.weatherhelper.mainweather.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherhelper.mainweather.databinding.MainLocationWeatherTitleBinding
import com.example.weatherhelper.mainweather.viewmodel.WeatherPresentation
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate

class TitleDelegate : AdapterDelegate<List<WeatherPresentation>>() {
    override fun isForViewType(items: List<WeatherPresentation>, position: Int): Boolean {
        return items[position] is WeatherPresentation.Title
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val binding = MainLocationWeatherTitleBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MainLocationTitleViewHolder(binding)
    }

    override fun onBindViewHolder(
        items: List<WeatherPresentation>,
        position: Int,
        holder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>
    ) {
        (holder as MainLocationTitleViewHolder).bind(items[position] as WeatherPresentation.Title)
    }

}

class MainLocationTitleViewHolder(
    private val binding: MainLocationWeatherTitleBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(title: WeatherPresentation.Title) {
        binding.searchView.queryHint = title.locationName
    }
}
