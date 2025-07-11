package com.example.weatherhelper.network.di

import com.example.weatherhelper.network.BuildConfig
import com.example.weatherhelper.network.DebugInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
internal class NetworkModule {

    @Provides
    @Singleton
    fun getOkHttp(): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .connectTimeout(120, TimeUnit.SECONDS)
            .writeTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
        if (BuildConfig.DEBUG) builder.addInterceptor(DebugInterceptor())
        return builder.build()
    }

    @Provides
    @Singleton
    fun getRetrofit(okHttpClient: OkHttpClient) {
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.BACKEND_URL)
            .build()
    }
}
