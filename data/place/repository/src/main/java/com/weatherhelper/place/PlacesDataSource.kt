package com.weatherhelper.place

import javax.inject.Inject

internal class PlacesDataSource @Inject constructor() {
    suspend fun getSelectedPlace(): Place {
        return Place(
            lat = 44.82184912850624,
            lon = 20.450216536447115,
            name = "Belgrade",
        )
    }
}