package me.tbsten.compose.dom.bow.gradle.plugin

import me.tbsten.compose.dom.bow.gradle.plugin.util.kotlin
import me.tbsten.compose.dom.bow.gradle.plugin.util.ksp
import me.tbsten.compose.dom.bow.gradle.plugin.util.requireNotNull
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.file.Directory
import org.gradle.api.provider.Provider
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import java.io.File

fun Project.registerBuildTask(
    bowConfiguration: BowConfiguration,
    buildOutputDir: Provider<Directory>,
    bowExtension: BowPluginExtension,
) {
    tasks.registerBowTask(
        "bowBuild${bowConfiguration.capitalizedConfName}",
        "<TODO>",
    ) { buildTask ->
        val clientProjects = bowExtension.entryProjects.clientPageProjects.values
        clientProjects.forEach {
            it.kotlin { configureBowJsTarget() }
        }
        val clientBuildTasks = clientProjects
            .map { clientProject ->
                clientProject.tasks.getByName(bowConfiguration.jsBuildTask).apply {
                    doLast {
                        copyClientBuiltOutputs(buildOutputDir, bowConfiguration, clientProject)
                    }
                }
            }.toTypedArray()

        val serverProject = bowExtension.entryProjects.serverProject
            .requireNotNull { "Not Configured `bow.entryProjects.server`." }
        val serverBuildTask = bowConfiguration.jvmBuildTask?.let { jvmBuildTask ->
            serverProject.tasks.getByName(jvmBuildTask)
                .doLast {
                    copyServerBuildOutputs(buildOutputDir, bowConfiguration, serverProject)
                }
        }
        serverProject.ksp {
            arg(
                "bowInternal.buildOutputDir",
                buildOutputDir.map { it.dir("static") }.get().asFile.absolutePath
            )
        }

        buildTask.dependsOn(
//            recreateBuildOutputDirTask,
            *clientBuildTasks,
        )
        serverBuildTask?.let {
            buildTask.dependsOn(
                serverBuildTask.apply { dependsOn(*clientBuildTasks) }
            )
        }
    }

    configureCleanTask(buildOutputDir)
}

private fun Project.configureCleanTask(
    buildOutputDir: Provider<Directory>,
) {
    fun Task.clean() {
        doLast {
            delete(buildOutputDir)
        }
    }
    if (tasks.findByName("clean") == null) {
        tasks.register("clean") {
            it.clean()
        }
    } else {
        tasks.getByName("clean") {
            it.clean()
        }
    }
}

private fun KotlinMultiplatformExtension.configureBowJsTarget() {
    js { jsTarget ->
        jsTarget.browser {
            commonWebpackConfig { webPackConfig ->
                webPackConfig.outputFileName = "mirrorball_client_page.js"
            }
        }
        jsTarget.binaries.executable()
    }
}

private fun copyClientBuiltOutputs(
    buildOutputDir: Provider<Directory>,
    bowConfiguration: BowConfiguration,
    clientProject: BowPluginEntryProjects.ClientPageProject,
) {
    val clientProjectBuildOutputDir = clientProject.layout
        .buildDirectory
        .file(bowConfiguration.jsBuildOutputDir)
        .get().asFile

    clientProjectBuildOutputDir.copyRecursively(
        File(
            buildOutputDir.map { it.dir("static") }.get().asFile,
            clientProject.modulePath,
        ),
        overwrite = true,
    )
}

private fun copyServerBuildOutputs(
    buildOutputDir: Provider<Directory>,
    bowConfiguration: BowConfiguration,
    serverProject: BowPluginEntryProjects.ServerProject,
) {
    val jvmBuildOutputDir = bowConfiguration.jvmBuildOutputDir ?: return
    val serverProjectBuildOutputDir = serverProject.layout
        .buildDirectory
        .file(jvmBuildOutputDir)
        .get().asFile

    serverProjectBuildOutputDir.copyRecursively(
        buildOutputDir.map { it.dir("server") }.get().asFile,
        overwrite = true,
    )
}
