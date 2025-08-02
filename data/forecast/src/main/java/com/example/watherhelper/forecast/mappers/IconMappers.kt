package com.example.watherhelper.forecast.mappers

import com.example.forecast.models.Icon

internal fun String.getIcon(): Icon {
    return when {
        this == "02d" || this == "02n" -> Icon.FEW_CLOUDS
        this == "04d" || this == "04n" || this == "03d" || this == "03n" -> Icon.CLOUDS
        this == "09d" || this == "09n" -> Icon.RAINY
        this == "10d" || this == "10n" -> Icon.RAIN
        this == "11d" || this == "11n" -> Icon.THUNDERSTORM
        this == "13d" || this == "13n" -> Icon.SNOW
        this == "50d" || this == "50n" -> Icon.MIST
        else -> Icon.CLEAR_SKY
    }
}
