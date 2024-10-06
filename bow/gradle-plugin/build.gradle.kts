plugins {
    alias(libs.plugins.kotlinJvm)
    `java-gradle-plugin`
    `maven-publish`
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.mirrorball.gralde.plugin)
}

dependencies {
    implementation(libs.kotlin.gradle.plugin)
    implementation(libs.kotlinx.serialization)
    implementation(libs.ktor.gradle.plugin)
    implementation(libs.ksp.gradle.plugin)
}

gradlePlugin {
    plugins {
        create("compose.dom.bow") {
            id = "me.tbsten.compose.dom.bow"
            version = "0.0.1"
            implementationClass =
                "me.tbsten.compose.dom.bow.gradle.plugin.BowPlugin"
            displayName = "Mirrorball Bow Plugin"
        }
        create("compose.dom.bow.server") {
            id = "me.tbsten.compose.dom.bow.server"
            version = "0.0.1"
            implementationClass =
                "me.tbsten.compose.dom.bow.gradle.plugin.BowServerPlugin"
            displayName = "Mirrorball Bow Server Plugin"
        }
    }
}

publishing {
    repositories {
        mavenLocal()
    }
}
