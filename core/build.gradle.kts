plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
    application
}

kotlin {
    jvm {
        this.withJava()
        withSourcesJar(true)
    }

    js {
        browser {
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
        }
        jvmMain.dependencies {
//            api("org.jetbrains.kotlin:kotlin-stdlib-jdk17:2.0.0")
        }
    }
}

