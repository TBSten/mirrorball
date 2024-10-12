plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.jetbrainsCompose) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.kotlinJvm) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.ktor) apply false
    alias(libs.plugins.ktlint) apply false
    alias(libs.plugins.kotlin.binary.compability.validator)

    id("me.tbsten.mirrorball.bow") version "0.0.1" apply false
}

buildscript {
    dependencies {
        classpath(kotlin("gradle-plugin", version = "2.0.20"))
    }
}
