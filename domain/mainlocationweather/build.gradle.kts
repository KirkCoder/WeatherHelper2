plugins {
    alias(libs.plugins.wh.kotlin)
}

dependencies {
    implementation(project(":domain:forecast"))
}
