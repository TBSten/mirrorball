package me.tbsten.mirrorball.bow.gradle.plugin.util

import org.gradle.api.file.Directory
import org.gradle.api.provider.Provider

fun Provider<Directory>.dir(path: String) = this.map { it.dir(path) }

fun Provider<Directory>.file(path: String) = this.map { it.file(path) }

fun Provider<Directory>.files(vararg paths: String) = this.map { it.files(paths) }
