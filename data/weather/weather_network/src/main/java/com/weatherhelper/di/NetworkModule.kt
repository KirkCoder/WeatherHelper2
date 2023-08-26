package com.weatherhelper.di

import com.weatherhelper.network.WeatherApiUrlSource
import com.weatherhelper.WeatherNetworkSource
import com.weatherhelper.network.ApiKeyInterceptor
import com.weatherhelper.network.WeatherOkHttp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    @Singleton
    internal fun okHttpCallFactory(apiKeyInterceptor: ApiKeyInterceptor): WeatherOkHttp {
        return object : WeatherOkHttp {
            override val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor())
                .addInterceptor(apiKeyInterceptor)
                .build()
        }
    }

    @Provides
    @Singleton
    internal fun weatherNetworkSource(
        weatherApiUrlSource: WeatherApiUrlSource,
        weatherOkHttp: WeatherOkHttp,
    ): WeatherNetworkSource {
        return Retrofit.Builder()
            .baseUrl(weatherApiUrlSource.weatherBaseUrl)
            .callFactory(weatherOkHttp.okHttpClient)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
            .create(WeatherNetworkSource::class.java)
    }
}