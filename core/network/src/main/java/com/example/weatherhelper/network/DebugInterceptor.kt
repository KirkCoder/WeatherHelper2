package com.example.weatherhelper.network

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Interceptor for debug http request
 * Print to logs url, headers, body
 */
internal class DebugInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        log(request.url.toString())
        request.headers.names().forEach {
            log(it)
        }
        log(request.body.toString())
        return chain.proceed(request)
    }
}

private fun log(message: String) {
    Log.d("WEATHER_HELPER_DEBUG", message)
}
