package com.weatherhelper.place

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface PlaceModule {

    @Provides
    fun providePlaceRepository(placesDataSource: PlacesDataSource): PlacesRepository {
        return PlaceRepositoryImpl(placesDataSource)
    }
}