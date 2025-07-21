package com.example.weatherhelper.mainlocation.mappers

import com.example.weatherhelper.mainlocation.MainLocationDao
import com.example.weatherhelper.mainlocationweather.models.MainLocation

fun MainLocationDao.toMainLocation(): MainLocation {
    return MainLocation(
        lat = lat,
        lon = lon,
        name = name,
    )
}
