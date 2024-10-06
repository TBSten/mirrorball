plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlinx.serialization)
}

kotlin {
    jvm()
    js {
        browser()
        binaries.library()
    }

    sourceSets {
        commonMain.dependencies {
            api(projects.bow)
            api(projects.bow.runtime)
            implementation(compose.runtime)
            implementation(libs.kotlinx.serialization)
        }
    }
}
