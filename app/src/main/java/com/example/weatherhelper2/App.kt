package com.example.weatherhelper2

import android.app.Application
import com.example.AppsDepsDataStore
import com.example.weatherhelper2.di.ApplicationComponent
import com.example.weatherhelper2.di.DaggerApplicationComponent
import com.example.weatherhelper2.di.FeatureComponent

class App: Application() {

    lateinit var component: ApplicationComponent
    lateinit var featureComponent: FeatureComponent

    override fun onCreate() {
        super.onCreate()
        app = this
        component = DaggerApplicationComponent
            .builder()
            .context(this)
            .build()

        val featureComponentBuilder = component.featureComponent()

        featureComponent = featureComponentBuilder.build()

        AppsDepsDataStore.deps = component
    }

    companion object {
        lateinit var app: App
    }
}