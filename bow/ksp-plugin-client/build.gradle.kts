plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.mirrorball.ksp.plugin)
}

dependencies {
    implementation(projects.bow.runtime)
    implementation("com.google.devtools.ksp:symbol-processing-api:2.0.20-1.0.24")
}
