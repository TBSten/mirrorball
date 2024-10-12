plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlinx.serialization)
}

kotlin {
    js {
        browser()
        binaries.executable()
    }

    sourceSets {
        jsMain.dependencies {
            implementation(projects.demo.bow.shared)
            implementation(libs.kotlinx.serialization)
            implementation(compose.runtime)
            implementation(libs.kotlinx.coroutines)
            implementation(libs.kotlin.wrappers.css)
        }
    }
}

dependencies {
    add("kspJs", projects.bow.kspPluginClient)
}
