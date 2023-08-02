package com.example.weatherhelper2.di

import com.example.feature.SomeProvidedClass
import com.example.weatherhelper2.ui.ClassA
import dagger.Module
import dagger.Provides

@Module(subcomponents = [FeatureComponent::class])
class MainModule {

    @Provides
    fun provide(): ClassA {
        return ClassA()
    }

    @Provides
    fun provideSomeProvidedClass(): SomeProvidedClass {
        return SomeProvidedClass("dkljfdl ")
    }
}