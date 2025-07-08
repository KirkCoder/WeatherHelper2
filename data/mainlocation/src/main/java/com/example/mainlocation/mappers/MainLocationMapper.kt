package com.example.mainlocation.mappers

import com.example.mainlocation.MainLocationDao
import com.example.mainlocationweather.models.MainLocation

fun MainLocationDao.toMainLocation(): MainLocation {
    return MainLocation(
        lat = lat,
        lon = lon,
        name = name,
    )
}
