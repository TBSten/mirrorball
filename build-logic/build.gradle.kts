import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

group = "me.tbsten.compose.dom.build.logic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
    }
}

dependencies {
    implementation("org.jlleitschuh.gradle:ktlint-gradle:12.1.1")
}

gradlePlugin {
    plugins {
        register("gradle-plugin") {
            id = "mirrorball.build.logic.gradle.plugin"
            implementationClass = "GradlePluginConventionPlugin"
        }
        register("ksp") {
            id = "mirrorball.build.logic.ksp.plugin"
            implementationClass = "KspPluginConvensionPlugin"
        }
        register("library") {
            id = "mirrorball.build.logic.library"
            implementationClass = "LibraryConvensionPlugin"
        }
    }
}
