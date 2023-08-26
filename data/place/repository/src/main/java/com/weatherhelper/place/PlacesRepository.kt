package com.weatherhelper.place

interface PlacesRepository {
    suspend fun getSelectedPlace(): Place
}