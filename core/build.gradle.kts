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
            implementation(libs.kotlinx.html)
            implementation(libs.kotlinx.coroutines)
            implementation(libs.kotlin.wrappers.css)

            api(projects.core.api)
            api(projects.core.htmlLib)
        }
        jvmMain.dependencies {
        }
    }
}

