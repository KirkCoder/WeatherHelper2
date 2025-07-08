import com.example.convention.WeatherHelperBuildType

plugins {
    alias(libs.plugins.wh.android.common)
}

android {
    namespace = "com.example.weatherhelper"

    defaultConfig {
        applicationId = "com.example.weatherhelper"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        buildConfig = true
    }

    buildTypes {
        debug {
            applicationIdSuffix = WeatherHelperBuildType.DEBUG.applicationIdSuffix
        }
        release {
            isMinifyEnabled = false
            applicationIdSuffix = WeatherHelperBuildType.RELEASE.applicationIdSuffix
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(project(":feature:weather"))
}
