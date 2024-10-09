package me.tbsten.compose.dom.bow.server.util

import java.io.Writer

class LinedWriter(private val writer: Writer) {
    fun writeln(line: String = "") {
        writer.write(line + "\n")
    }
}
