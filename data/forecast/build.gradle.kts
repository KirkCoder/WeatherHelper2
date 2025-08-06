plugins {
    alias(libs.plugins.wh.android.library)
    id("kotlinx-serialization")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
}

android {
    namespace = "com.example.watherhelper.forecast"
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(libs.retrofit.core)
    implementation(libs.kotlinx.serialization.json)
    implementation(project(":domain:mainlocationforecast"))
    implementation(project(":domain:forecast"))
    implementation(project(":core:network"))
    implementation(project(":core:coroutines"))
}
