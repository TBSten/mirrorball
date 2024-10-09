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
        create("mirrorball.bow") {
            id = "me.tbsten.mirrorball.bow"
            version = "0.0.1"
            implementationClass =
                "me.tbsten.mirrorball.bow.gradle.plugin.BowPlugin"
            displayName = "Mirrorball Bow Plugin"
        }
        create("mirrorball.bow.server") {
            id = "me.tbsten.mirrorball.bow.server"
            version = "0.0.1"
            implementationClass =
                "me.tbsten.mirrorball.bow.gradle.plugin.BowServerPlugin"
            displayName = "Mirrorball Bow Server Plugin"
        }
    }
}

publishing {
    repositories {
        mavenLocal()
    }
}
