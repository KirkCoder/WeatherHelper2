package com.weatherhelper

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val weatherHelperDispatchers: WeatherHelperDispatchers)

enum class WeatherHelperDispatchers {
    Default,
    IO,
}