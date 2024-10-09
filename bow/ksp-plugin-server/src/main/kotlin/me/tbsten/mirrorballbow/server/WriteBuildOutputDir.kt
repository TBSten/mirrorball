package me.tbsten.mirrorballbow.server

import java.io.Writer

fun Writer.writeBuildOutputDir(buildOutputDir: String) =
    LinedWriter(this).apply {
        writeln("package me.tbsten.mirrorball.bow.server.generated")
        writeln()
        writeln("import java.io.File")
        writeln()
        writeln("""val BowBuildOutputDir = File("$buildOutputDir")""")
        writeln()
    }
