import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    js {
        moduleName = "demo-app"
        browser {
            commonWebpackConfig {
                outputFileName = "demo-app.js"
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                    static = (static ?: mutableListOf()).apply {
                        // Serve sources to debug inside browser
                        add(project.projectDir.path)
                    }
                }
                mode = KotlinWebpackConfig.Mode.DEVELOPMENT
            }
        }
        binaries.executable()
    }

    sourceSets {
        commonMain.dependencies {
//            implementation(projects.demo.shared)
        }
        jsMain.dependencies {
            implementation(compose.runtime)
            implementation(projects.demo.basic.shared)
            implementation(libs.kotlinx.coroutines)
        }
    }
}

