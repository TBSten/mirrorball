plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.ktor)
    application
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.ksp)
    id("me.tbsten.compose.dom.bow.server") version "0.0.1"
}

group = "me.tbsten.compose.dom.demo.basic.server"
version = "1.0.0"
application {
    mainClass.set("me.tbsten.compose.dom.demo.bow.server.ApplicationKt")
    applicationDefaultJvmArgs = listOf(
        "-Dio.ktor.development=${extra["io.ktor.development"] ?: "false"}",
    )
}

// TODO move to plugin
// refs: https://youtrack.jetbrains.com/issue/KTOR-7522/Is-there-an-artifact-for-build-logic-module-in-ktor-gradle-plugin
//ktor {
//    fatJar {
//        archiveFileName = "mirrorball-bow-server-output.jar"
//    }
//}

dependencies {
    implementation(libs.logback)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)
    testImplementation(libs.ktor.server.tests)
    testImplementation(libs.kotlin.test.junit)

    implementation(projects.demo.bow.shared)
    implementation(compose.runtime)
    implementation(libs.kotlinx.coroutines)
    implementation(libs.kotlin.wrappers.css)

    implementation(projects.ktor)

    implementation(projects.bow.runtime)
    ksp(projects.bow.kspPluginClient)
    ksp(projects.bow.kspPluginServer)
}

//ksp {
//    val clientPageModules =
//        projects
//            .demo.bow.dependencyProject.layout
//            .buildDirectory
//            .file("bow/clientPageModules.json")
//            .get().asFile.absolutePath
//    arg(
//        "bow.clientPageModules",
//        clientPageModules,
//    )
//}
