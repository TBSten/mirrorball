plugins {
    kotlin("jvm")
}

dependencies {
    implementation(projects.bow.runtime)
    implementation("com.google.devtools.ksp:symbol-processing-api:2.0.20-1.0.24")
}
