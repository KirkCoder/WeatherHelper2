package com.example.feature.di

import androidx.annotation.RestrictTo
import com.example.feature.SomeProvidedClass

interface AppDeps {
    @get:RestrictTo(RestrictTo.Scope.LIBRARY)
    val sc: SomeProvidedClass
}