package com.example.weatherhelper.mainweather.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.feature.weather.R
import androidx.fragment.app.viewModels
import com.example.feature.weather.databinding.MainLocationWeatherBinding
import com.example.weatherhelper.mainweather.viewmodel.MainLocationWeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainLocationWeatherFragment: Fragment(R.layout.main_location_weather) {

    private val viewModel: MainLocationWeatherViewModel by viewModels()

    private var _binding: MainLocationWeatherBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainLocationWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.forecastLiveData.observe(viewLifecycleOwner){ forecast ->
            binding.mainInfo.text = forecast.name + forecast.forecasts.forecast
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
