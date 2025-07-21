package com.example.weatherhelper.mainweather.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.weatherhelper.mainweather.databinding.MainLocationWeatherBinding
import com.example.weatherhelper.mainweather.viewmodel.MainLocationWeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainLocationWeatherFragment: Fragment() {

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
            binding.swipeRefresh.isRefreshing = false
        }

        binding.swipeRefresh.setOnRefreshListener {
            viewModel.update()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
