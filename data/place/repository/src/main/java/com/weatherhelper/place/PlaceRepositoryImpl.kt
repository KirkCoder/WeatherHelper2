package com.weatherhelper.place

internal class PlaceRepositoryImpl(
    private val placesDataSource: PlacesDataSource
): PlacesRepository {
    override suspend fun getSelectedPlace(): Place {
        return placesDataSource.getSelectedPlace()
    }
}