plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.mirrorball.library)
}

kotlin {
    jvm()
    js {
        browser {
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(libs.kotlinx.serialization)

            api(projects.core)
        }
        jvmMain.dependencies {
            implementation(libs.ktor.server.core)
            api(projects.ktor)
        }
    }
}
