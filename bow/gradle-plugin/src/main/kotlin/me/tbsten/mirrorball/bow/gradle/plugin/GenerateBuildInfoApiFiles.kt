package me.tbsten.mirrorball.bow.gradle.plugin

import me.tbsten.mirrorball.bow.gradle.plugin.util.dir
import me.tbsten.mirrorball.bow.gradle.plugin.util.file
import me.tbsten.mirrorball.bow.gradle.plugin.util.toUpperCamelCase
import me.tbsten.mirrorball.bow.gradle.plugin.util.writeFile
import me.tbsten.mirrorball.bow.server.util.LinedWriter
import org.gradle.api.Project
import org.gradle.api.file.Directory
import org.gradle.api.provider.Provider
import java.io.Writer
import java.nio.file.Paths

internal fun generateBuildInfoApiFiles(
    serverProject: Project,
    clientProjects: List<BowPluginEntryProjects.ClientScriptProject>,
    buildOutputDir: Provider<Directory>,
) {
    val buildInfoOutputDir =
        serverProject.layout
            .buildDirectory
            .dir("bow/buildInfo")
    // generate BowBuildOutputStaticDir
    val buildOutputStaticDir = buildOutputDir.dir("static")
    buildInfoOutputDir
        .file("me/tbsten/mirrorball/bow/buildInfo/generated/BowBuildOutputStaticDir.kt")
        .writeFile {
            writeBuildOutputDir(buildOutputStaticDir.get().asFile.absolutePath)
        }

    // generate BowClientScripts
    buildInfoOutputDir
        .file("me/tbsten/mirrorball/bow/buildInfo/generated/BowClientScripts.kt")
        .writeFile {
            writeClientScripts(clientProjects)
        }
}

internal fun Writer.writeBuildOutputDir(buildOutputStaticDir: String) =
    LinedWriter(this).apply {
        writeln("package me.tbsten.mirrorball.bow.buildInfo.generated")
        writeln()
        writeln("import java.io.File")
        writeln()
        writeln("""val BowBuildOutputStaticDir = File("$buildOutputStaticDir")""")
        writeln()
    }

internal fun Writer.writeClientScripts(clientProjects: List<BowPluginEntryProjects.ClientScriptProject>) =
    LinedWriter(this).apply {
        writeln("package me.tbsten.mirrorball.bow.buildInfo.generated")
        writeln()
        writeln("import me.tbsten.mirrorball.bow.ClientScript")
        writeln()
        writeln("object BowClientScripts : List<ClientScript> by listOf(")
        clientProjects.forEach { clientProject ->
            writeln("    ${clientProject.clientScriptObjectName},")
        }
        writeln(") {")
        clientProjects.forEach { clientProject ->
            val pathInStaticDir = "/${Paths.get(clientProject.modulePath, ClientScriptFileName)}"
            writeln("    object ${clientProject.clientScriptObjectName} : ClientScript(pathInStaticDir = \"$pathInStaticDir\")")
        }
        writeln("}")
        writeln()
    }

internal val BowPluginEntryProjects.ClientScriptProject.clientScriptObjectName: String
    get() =
        path
            .split(":")
            .map {
                it
                    .let {
                        if (it.matches(Regex("^[0-9]"))) {
                            "_$it"
                        } else {
                            it
                        }
                    }.split(Regex("[-:/\\\\!?]"))
                    .toUpperCamelCase()
            }.joinToString("") { it.toUpperCamelCase() }
