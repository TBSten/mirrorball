rootProject.name = "mirrorball"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        mavenLocal()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
    }
}

include(":core")
include(":core:core-api")
include(":core:html-lib")
include(":ktor")

include(":bow")
include(":bow:gradle-plugin")
include(":bow:ksp-plugin-client")
include(":bow:ksp-plugin-server")
include(":bow:runtime")

include(":generate")

include(":demo:basic:client")
include(":demo:basic:shared")
include(":demo:basic:server")
include(":demo:client-slot")
include(":demo:client-slot:client")
include(":demo:client-slot:shared")
include(":demo:client-slot:server")
