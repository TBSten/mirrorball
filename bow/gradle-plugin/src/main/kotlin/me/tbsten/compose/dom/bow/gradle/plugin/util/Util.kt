package me.tbsten.compose.dom.bow.gradle.plugin.util

fun <T : Any> T?.requireNotNull(lazyMessage: () -> String): T {
    return requireNotNull(this, lazyMessage)
}
