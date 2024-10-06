rootProject.name = "mirrorball"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
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
include(":core:api")
include(":core:html-lib")
include(":bow")
include(":bow:gradle-plugin")
include(":bow:ksp-plugin-client")
include(":bow:ksp-plugin-server")
include(":bow:runtime")

include(":generate")

include(":demo:basic:client")
include(":demo:basic:shared")
include(":demo:basic:server")
