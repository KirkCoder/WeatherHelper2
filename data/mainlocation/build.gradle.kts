plugins {
    alias(libs.plugins.wh.android.library)
}

android {
    namespace = "com.example.weatherhelper.mainlocation"
}

dependencies {
    implementation(project(":domain:mainlocationweather"))
}
