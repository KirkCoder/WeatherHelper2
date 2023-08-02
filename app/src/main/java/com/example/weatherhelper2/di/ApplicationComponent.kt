package com.example.weatherhelper2.di

import android.content.Context
import com.example.feature.di.AppDeps
import com.example.weatherhelper2.MainActivity
import dagger.BindsInstance
import dagger.Component

@Component(modules = [MainModule::class, BindsModule::class])
interface ApplicationComponent : AppDeps {

    fun featureComponent(): FeatureComponent.Builder

    fun inject(activity: MainActivity)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): ApplicationComponent
    }
}