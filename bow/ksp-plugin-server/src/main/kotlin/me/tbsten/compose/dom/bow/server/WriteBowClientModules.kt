package me.tbsten.compose.dom.bow.server

import java.io.Writer
import java.util.Locale

internal fun Writer.writeBowClientModules(
    clientPageModules: Map<String, BowClientModule>,
) = LinedWriter(this).apply {
    writeln("package me.tbsten.compose.dom.bow.server.generated")
    writeln()
    writeln("import java.io.File")
    writeln()
    writeln("sealed class BowClientModule(val module: String, val projectDir: File, val staticDir: File)")
    writeln()
    writeln("data object BowClientModules : List<BowClientModule> by listOf(")
    clientPageModules.forEach { (modulePath, _) ->
        writeln("    ${moduleEntryName(modulePath)},")
    }
    writeln("){")
    clientPageModules.forEach { (modulePath, module) ->
        val moduleEntryName = moduleEntryName(modulePath)
        writeln("""    data object $moduleEntryName : BowClientModule("${module.module}", File("${module.projectDir}"), File("${module.staticDir}"))""")
    }
    writeln("}")
    writeln()
}

fun moduleEntryName(modulePath: String) =
    modulePath.split(":")
        .joinToString("") { it.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() } }

class LinedWriter(private val writer: Writer) {
    fun writeln(line: String = "") {
        writer.write(line + "\n")
    }
}
