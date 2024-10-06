package me.tbsten.compose.dom.bow.server.util

fun <T : Any> T?.requireNotNull(): T {
    return requireNotNull(this)
}

fun <T : Any> T?.requireNotNull(lazyMessage: () -> String): T {
    return requireNotNull(this, lazyMessage)
}
