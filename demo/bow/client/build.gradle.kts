plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlinx.serialization)
//    id("me.tbsten.compose.dom.bow.client.page") version "0.0.1"
}

kotlin {
    js {
        browser {
            commonWebpackConfig {
                sourceMaps = false
            }
        }
        binaries.executable()
    }

    sourceSets {
        commonMain.dependencies {
            implementation(projects.demo.bow.shared)
            implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.1")
        }
        jsMain.dependencies {
            implementation(compose.runtime)
            implementation(projects.demo.basic.shared)
            implementation(libs.kotlinx.coroutines)
            implementation(libs.kotlin.wrappers.css)
        }
    }

    dependencies {
        ksp(projects.bow.kspPluginClient)
    }
}

//bowClientPage {
//    module = "/"
//}
