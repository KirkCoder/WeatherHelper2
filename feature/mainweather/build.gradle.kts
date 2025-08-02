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
    implementation(project(":core:coroutines"))
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.swipe)
    implementation(libs.android.adapter.delegate)
    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
}
