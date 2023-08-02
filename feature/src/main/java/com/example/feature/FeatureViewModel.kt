package com.example.feature

import androidx.lifecycle.ViewModel
import com.example.AppDepsProvider
import com.example.feature.di.DaggerFeatureAppComponent

class FeatureViewModel: ViewModel() {
    val featureComponent = DaggerFeatureAppComponent.builder()
        .deps(AppDepsProvider.deps)
        .build()
}