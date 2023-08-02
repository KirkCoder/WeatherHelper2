package com.example.feature.di

import com.example.feature.FeatureActivity
import dagger.Component

@Component(dependencies = [AppDeps::class])
interface FeatureAppComponent {

    fun inject(activity: FeatureActivity)

    @Component.Builder
    interface Builder {

        fun deps(depsd: AppDeps): Builder

        fun build(): FeatureAppComponent
    }
}