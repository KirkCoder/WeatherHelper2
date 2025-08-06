package com.example.watherhelper.forecast.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ForecastsDto(
    val cod: String,
    val message: Int,
    val list: List<ForecastDto>
)

@Serializable
data class ForecastDto(
    @SerialName("dt")
    val dt: Long,

    @SerialName("main")
    val main: MainInfo,

    @SerialName("weather")
    val weather: List<WeatherInfo>,

    @SerialName("clouds")
    val clouds: CloudsInfo,

    @SerialName("wind")
    val wind: WindInfo,

    @SerialName("visibility")
    val visibility: Int,

    @SerialName("pop")
    val pop: Double, // Вероятность осадков

    // Объект rain может отсутствовать, если нет дождя, поэтому делаем его nullable
    @SerialName("rain")
    val rain: RainInfo? = null,

    @SerialName("sys")
    val sys: SysInfo,

    @SerialName("dt_txt")
    val dtTxt: String
)

@Serializable
data class MainInfo(
    @SerialName("temp")
    val temp: Double,

    @SerialName("feels_like")
    val feelsLike: Double,

    @SerialName("temp_min")
    val tempMin: Double,

    @SerialName("temp_max")
    val tempMax: Double,

    @SerialName("pressure")
    val pressure: Int,

    @SerialName("sea_level")
    val seaLevel: Int,

    @SerialName("grnd_level")
    val groundLevel: Int,

    @SerialName("humidity")
    val humidity: Int,

    @SerialName("temp_kf")
    val tempKf: Double
)

@Serializable
data class WeatherInfo(
    @SerialName("id")
    val id: Int,

    @SerialName("main")
    val main: String,

    @SerialName("description")
    val description: String,

    @SerialName("icon")
    val icon: String
)

@Serializable
data class CloudsInfo(
    @SerialName("all")
    val all: Int // Процент облачности
)

@Serializable
data class WindInfo(
    @SerialName("speed")
    val speed: Double,

    @SerialName("deg")
    val deg: Int,

    @SerialName("gust")
    val gust: Double
)

@Serializable
data class RainInfo(
    // Имя поля "3h" невалидно в Kotlin, поэтому используем @SerialName
    @SerialName("3h")
    val last3h: Double // Объем осадков за последние 3 часа
)

@Serializable
data class SysInfo(
    // pod (part of day): "d" for day, "n" for night
    @SerialName("pod")
    val pod: String
)
