package com.example.weatherhelper.mainweather.mappers

import android.content.Context
import androidx.annotation.DrawableRes
import com.example.forecast.models.Forecast
import com.example.forecast.models.Icon
import com.example.weatherhelper.mainlocationweather.models.MainLocationWeatherForecast
import com.example.weatherhelper.mainweather.R
import com.example.weatherhelper.mainweather.viewmodel.WeatherPresentation
import kotlin.math.roundToInt

internal fun MainLocationWeatherForecast.map(context: Context): MutableList<WeatherPresentation> {
    val weatherPresentations = mutableListOf<WeatherPresentation>()
    weatherPresentations.add(WeatherPresentation.Title(name))
    weatherPresentations.add(forecasts.first().mainWeather(context))
    for (i in 1 until forecasts.size) {
        weatherPresentations.add(
            forecasts[i].mapHoursWeather(context)
        )
    }
    return weatherPresentations
}

internal fun Forecast.mapHoursWeather(context: Context): WeatherPresentation.HoursWeather {
    return WeatherPresentation.HoursWeather(
        temp = getTemperature(context),
        dt = mapTime(),
        icon = mapIcon()
    )
}

private fun Forecast.mapTime(): String {
    return dt.split(" ").getOrNull(1)?.split(":")?.take(2)?.joinToString(":") ?: dt
}

private fun Double.mapTemperature(): Int {
    return this.roundToInt()
}

internal fun Forecast.mainWeather(context: Context): WeatherPresentation.MainWeather {
    return WeatherPresentation.MainWeather(
        temp = getTemperature(context),
        feelsLike = context.getString(R.string.feels_like, feelsLike.mapTemperature()),
        dt = dt,
        clouds = mapClouds(context),
        wind = mapWind(context),
        rain = mapRain(context),
        icon = mapIcon(),
        description = description,
    )
}

private fun Forecast.getTemperature(context: Context) =
    context.getString(R.string.temp, temp.mapTemperature())

private fun Forecast.mapWind(context: Context): String {
    return context.getString(R.string.wind, windSpeed.roundToInt())
}

private fun Forecast.mapClouds(context: Context): String {
    return context.getString(R.string.clouds, clouds)
}

private fun Forecast.mapRain(context: Context): String {
    return context.getString(R.string.rain, rain.roundToInt())
}

@DrawableRes
private fun Forecast.mapIcon(): Int {
    return when(icon){
        Icon.FEW_CLOUDS -> R.drawable.free_icon_cloudy
        Icon.CLOUDS -> R.drawable.free_icon_foggy
        Icon.RAINY -> R.drawable.free_icon_rainy
        Icon.RAIN -> R.drawable.free_icon_rain
        Icon.THUNDERSTORM -> R.drawable.free_icon_thunderstorm
        Icon.SNOW -> R.drawable.free_icon_snow
        Icon.MIST -> R.drawable.free_icon_foggy
        else -> R.drawable.free_icon_sun
    }
}
