package com.example.weatherhelper2.di

import dagger.Subcomponent

@Subcomponent(modules = [FeatureModule::class])
interface FeatureComponent {

//    fun inject(activity: MainActivity)


    @Subcomponent.Builder
    interface Builder {
        fun build(): FeatureComponent
    }
}