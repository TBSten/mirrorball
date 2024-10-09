package me.tbsten.mirrorball.bow.gradle.plugin.util

fun <T : Any> T?.requireNotNull(lazyMessage: () -> String): T = requireNotNull(this, lazyMessage)
