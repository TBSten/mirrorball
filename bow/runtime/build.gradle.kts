plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
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

            api(projects.core)
        }
        jvmMain.dependencies {
            implementation(libs.ktor.server.core)
            api(projects.ktor)
        }
    }

}
