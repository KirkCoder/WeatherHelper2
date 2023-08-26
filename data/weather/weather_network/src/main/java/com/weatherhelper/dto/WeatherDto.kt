package com.weatherhelper.dto

import com.google.gson.annotations.SerializedName
import dev.afanasev.kson.annotation.Kson

@Kson
data class WeatherListDto(
    val dt: Long?,
    val clouds: CloudsDto?,
    val wind: WindDto?,
    val visibility: Long?,
    val pop: Double?,
    val rain: RainDto?,
    val sys: SysDto?,
    @SerializedName("dt_txt")
    val dtTxt: String?,
    val coord: CoordDto?,
    val weather: List<WeatherDto>?,
    val base: String?,
    val main: MainWeatherInfoDto?,
    val timezone: Long?,
    val id: Long?,
    val name: String?,
    val cod: String?,
)

@Kson
data class CoordDto(
    val lon: Double?,
    val lat: Double?,
)

@Kson
data class WeatherDto(
    val id: Long?,
    val main: String?,
    val description: String?,
    val icon: String?,
)

@Kson
data class MainWeatherInfoDto(
    val temp: Double?,
    @SerializedName("feels_like")
    val feelsLike: Double?,
    @SerializedName("temp_min")
    val tempMin: Double?,
    @SerializedName("temp_max")
    val tempMax: Double?,
    val pressure: Long?,
    val humidity: Long?,
    @SerializedName("sea_level")
    val seaLevel: Long?,
    @SerializedName("grnd_level")
    val grndLevel: Long?,
    @SerializedName("temp_kf")
    val tempKf: Double?,
)

@Kson
data class WindDto(
    val speed: Double?,
    val deg: Long?,
    val gust: Double?,
)

data class RainDto(
    @SerializedName("1h")
    val n1h: Double?,
    @SerializedName("3h")
    val n3h: Double?,
)

@Kson
data class CloudsDto(
    val all: Long?,
)

@Kson
data class SysDto(
    val pod: String?,
    val type: Long?,
    val id: Long?,
    val country: String?,
    val sunrise: Long?,
    val sunset: Long?,
)