package com.example.weatherhelper2.di

import com.example.weatherhelper2.ui.ClassB
import dagger.Module
import dagger.Provides

@Module
class FeatureModule {

    @Provides
    fun provideB(): ClassB {
        return ClassB()
    }
}