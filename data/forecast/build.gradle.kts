plugins {
    alias(libs.plugins.wh.android.library)
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
}

android {
    namespace = "com.example.watherhelper.forecast"
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(project(":domain:mainlocationweather"))
}
