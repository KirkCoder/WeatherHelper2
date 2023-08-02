package com.example

import com.example.feature.di.AppDeps
import kotlin.properties.Delegates.notNull

interface AppDepsProvider {
    val deps: AppDeps

    companion object : AppDepsProvider by AppsDepsDataStore
}

object AppsDepsDataStore : AppDepsProvider {
    override var deps: AppDeps by notNull()
}