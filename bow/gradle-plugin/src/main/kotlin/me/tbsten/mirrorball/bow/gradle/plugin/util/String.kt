package me.tbsten.mirrorball.bow.gradle.plugin.util

import java.util.Locale

fun String.toUpperCamelCase() = this.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }

fun Iterable<String>.toUpperCamelCase() = this.joinToString("") { it.toUpperCamelCase() }
