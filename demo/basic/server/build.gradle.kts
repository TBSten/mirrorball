plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.ktor)
    application
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
}

group = "me.tbsten.mirrorball.demo.basic.server"
version = "1.0.0"
application {
    mainClass.set("me.tbsten.mirrorball.demo.basic.server.ApplicationKt")
    applicationDefaultJvmArgs =
        listOf(
            "-Dio.ktor.development=${extra["io.ktor.development"] ?: "false"}",
        )
}

dependencies {
    implementation(libs.logback)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)
    testImplementation(libs.ktor.server.tests)
    testImplementation(libs.kotlin.test.junit)

    implementation(projects.demo.basic.shared)
    implementation(compose.runtime)
    implementation(libs.kotlinx.coroutines)
    implementation(libs.kotlin.wrappers.css)

    implementation(projects.core.coreApi)
    implementation(projects.core.htmlLib)
}
