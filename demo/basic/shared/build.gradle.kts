plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    js {
        browser {
        }
    }

    jvm()

    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            api(projects.core)
        }
    }
}

