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
include(":demo:bow")
include(":demo:bow:client")
include(":demo:bow:client:top")
include(":demo:bow:client:client-slot")
include(":demo:bow:shared")
include(":demo:bow:server")
