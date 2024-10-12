package me.tbsten.mirrorball.bow.gradle.plugin.util

import org.gradle.api.file.RegularFile
import org.gradle.api.provider.Provider
import java.io.File
import java.io.Writer

fun File.writeFile(write: Writer.(File) -> Unit) {
    val file = this
    file.parentFile.mkdirs()
    file
        .writer()
        .use {
            it.write(file)
        }
}

fun RegularFile.writeFile(write: Writer.(File) -> Unit) = this.asFile.writeFile(write)

fun Provider<RegularFile>.writeFile(write: Writer.(File) -> Unit) = this.get().writeFile(write)
