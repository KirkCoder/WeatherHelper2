package com.example.weatherhelper2.di

import com.example.weatherhelper2.ui.MapClass
import dagger.MapKey
import kotlin.reflect.KClass

@MustBeDocumented
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class MapClassKey(val value: KClass<out MapClass>)
