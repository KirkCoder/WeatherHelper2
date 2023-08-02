package com.example.weatherhelper2.di

import com.example.weatherhelper2.ui.MapClass
import com.example.weatherhelper2.ui.MapClassA
import com.example.weatherhelper2.ui.MapClassB
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
interface BindsModule {

    @Binds
    @[IntoMap MapClassKey(MapClassB::class)]
    fun provideMapB2(mapClassB: MapClassB): MapClass

    @Binds
    @[IntoMap MapClassKey(MapClassA::class)]
    fun provideMapA2(mapClassA: MapClassA): MapClass

    @Binds
    @[IntoMap ClassKey(MapClassB::class)]
    fun provideMapB(mapClassB: MapClassB): MapClass

    @Binds
    @[IntoMap ClassKey(MapClassA::class)]
    fun provideMapA(mapClassA: MapClassA): MapClass
}