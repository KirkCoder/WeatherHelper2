plugins {
    alias(libs.plugins.wh.android.feature)
}

android {
    namespace = "com.example.weatherhelper.mainweather"
    viewBinding {
        enable = true
    }
}


dependencies {
    implementation(project(":domain:mainlocationforecast"))
    implementation(project(":domain:forecast"))
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.fragment.ktx)
}
