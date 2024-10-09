package me.tbsten.mirrorball.bow.server.util

fun <T : Any> T?.requireNotNull(): T = requireNotNull(this)

fun <T : Any> T?.requireNotNull(lazyMessage: () -> String): T = requireNotNull(this, lazyMessage)
