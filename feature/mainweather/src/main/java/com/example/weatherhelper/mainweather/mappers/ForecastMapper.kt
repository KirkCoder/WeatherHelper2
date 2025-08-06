package com.example.weatherhelper.mainweather.mappers

import android.content.Context
import androidx.annotation.DrawableRes
import com.example.forecast.models.Forecast
import com.example.forecast.models.Icon
import com.example.weatherhelper.mainlocationweather.models.MainLocationWeatherForecast
import com.example.weatherhelper.mainweather.R
import com.example.weatherhelper.mainweather.viewmodel.WeatherPresentation
import java.time.LocalDate
import kotlin.math.roundToInt

private val dayHours = mutableSetOf("12:00", "15:00")

internal fun MainLocationWeatherForecast.map(context: Context): MutableList<WeatherPresentation> {
    val weatherPresentations = mutableListOf<WeatherPresentation>()
    val hoursWeather = mutableListOf<WeatherPresentation.HoursWeather.HourWeather>()
    weatherPresentations.add(WeatherPresentation.Title(name))
    weatherPresentations.add(forecasts.first().mainWeather(context))
    val firstDay = getDay(forecasts.first().dt)

    for (i in 1 until Math.min(forecasts.size, 18)) {
        hoursWeather.add(
            forecasts[i].mapHoursWeather(context)
        )
    }
    weatherPresentations.add(WeatherPresentation.HoursWeather(hoursWeather))

    var i = 1
    while (i < forecasts.size && getDay(forecasts[i].dt) == firstDay) {
        i++
    }

    val map = mutableMapOf<LocalDate, MutableList<Forecast>>()

    while (i < forecasts.size) {
        val dt = getDay(forecasts[i].dt)
        val list = map[dt] ?: mutableListOf()
        list.add(forecasts[i])
        map[dt] = list
        i++
    }

    var currDay = firstDay.plusDays(1)
    var dailyForecast = map[currDay]
    while (!dailyForecast.isNullOrEmpty()) {
        var nightTmp: String? = null
        var dayTmp = 0.0
        var rain = 0.0
        var icon: Int? = null
        var timesCount = 0
        for (forecast in dailyForecast) {
            val time = forecast.mapTime()
            if (time == "03:00") {
                nightTmp = forecast.temp.getTemperature(context)
            }
            if (time in dayHours) {
                dayTmp += forecast.temp
                rain += forecast.rain
                if (icon == null) icon = forecast.icon.mapIcon()
                timesCount++
            }
        }
        if (nightTmp != null && timesCount == 2 && icon != null) {
            weatherPresentations.add(
                WeatherPresentation.DayWeather(
                    dayTemp = (dayTmp / 2.0).getTemperature(context),
                    nightTemp = nightTmp,
                    dt = currDay.toString(),
                    rain = (rain / 2.0).mapRain(context),
                    icon = icon
                )
            )
        }

        currDay = currDay.plusDays(1)
        dailyForecast = map[currDay]
    }

    return weatherPresentations
}

private fun getDay(dt: String): LocalDate {
    return LocalDate.parse(dt.split(" ")[0])
}

internal fun Forecast.mapHoursWeather(context: Context): WeatherPresentation.HoursWeather.HourWeather {
    return WeatherPresentation.HoursWeather.HourWeather(
        temp = temp.getTemperature(context),
        dt = mapTime(),
        icon = icon.mapIcon()
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
        temp = temp.getTemperature(context),
        feelsLike = context.getString(R.string.feels_like, feelsLike.mapTemperature()),
        dt = dt,
        clouds = mapClouds(context),
        wind = mapWind(context),
        rain = rain.mapRain(context),
        icon = icon.mapIcon(),
        description = description,
    )
}

private fun Double.getTemperature(context: Context) =
    context.getString(R.string.temp, mapTemperature())

private fun Forecast.mapWind(context: Context): String {
    return context.getString(R.string.wind, windSpeed.roundToInt())
}

private fun Forecast.mapClouds(context: Context): String {
    return context.getString(R.string.clouds, clouds)
}

private fun Double.mapRain(context: Context): String {
    return context.getString(R.string.rain, roundToInt())
}

@DrawableRes
private fun Icon.mapIcon(): Int {
    return when (this) {
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
