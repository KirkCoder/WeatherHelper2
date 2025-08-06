package com.example.weatherhelper.network.di

import android.content.Context
import com.example.weatherhelper.network.BuildConfig
import com.example.weatherhelper.network.DebugInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import kotlinx.serialization.json.Json
import okhttp3.Cache
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.dnsoverhttps.DnsOverHttps
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import java.net.InetAddress
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
internal class NetworkModule {

    @Provides
    @Singleton
    fun getOkHttp(@ApplicationContext context: Context): OkHttpClient {

        val builder = OkHttpClient.Builder()
            .connectTimeout(120, TimeUnit.SECONDS)
            .writeTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
        if (BuildConfig.DEBUG) {

            val appCache = Cache(context.cacheDir, 10_000_000)

            val dns = DnsOverHttps.Builder()
                .client(
                    OkHttpClient.Builder().cache(appCache).build()
                ) // Использует свой OkHttp-клиент для DNS-запросов
                .url("https://cloudflare-dns.com/dns-query".toHttpUrl())
                .bootstrapDnsHosts(InetAddress.getByName("1.1.1.1"), InetAddress.getByName("1.0.0.1"))
                .build()

            builder.addInterceptor(DebugInterceptor())
                .dns(dns)
        }
        return builder.build()
    }

    @Provides
    @Singleton
    fun getRetrofit(okHttpClient: OkHttpClient, networkJson: Json): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.BACKEND_URL)
            .addConverterFactory(
                networkJson.asConverterFactory("application/json".toMediaType()),
            )
            .build()
    }

    @Provides
    @Singleton
    fun providesNetworkJson(): Json = Json {
        ignoreUnknownKeys = true
    }
}
