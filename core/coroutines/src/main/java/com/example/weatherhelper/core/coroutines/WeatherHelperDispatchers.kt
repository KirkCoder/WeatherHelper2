package com.example.weatherhelper.core.coroutines

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

@Qualifier
@Retention(RUNTIME)
annotation class Dispatcher(val dispatcher: WeatherHelperDispatchers)

enum class WeatherHelperDispatchers {
    Default,
    IO,
}
