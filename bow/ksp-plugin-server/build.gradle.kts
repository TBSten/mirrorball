plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.kotlinx.serialization)
}

dependencies {
    implementation(projects.bow.runtime)
    implementation(libs.ksp.api)
    implementation(libs.kotlinx.serialization)
}
