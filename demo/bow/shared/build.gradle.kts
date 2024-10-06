import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.ksp)
}

kotlin {
    jvm()
    js {
        moduleName = "demo-app"
        browser {
            commonWebpackConfig {

                cssSupport {
                    enabled = true
                    mode.set("extract")
                    outputFileName = "webpack-css-output"
                    this.test.set("/\\.css$/i")
                }
                outputFileName = "demo-app.js"
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                    static = (static ?: mutableListOf()).apply {
                        add(project.projectDir.path)
                    }
                }
            }
        }
        binaries.executable()
    }

    sourceSets {
        commonMain.dependencies {
            api(projects.bow)
            api(projects.bow.runtime)
        }
        jsMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.animation)
            implementation(libs.kotlinx.coroutines)
            implementation(libs.kotlin.wrappers.css)
        }
    }
    dependencies {
        ksp(projects.bow.kspPluginClient)
    }
}
