package me.tbsten.compose.dom.bow.gradle.plugin

import me.tbsten.compose.dom.bow.gradle.plugin.util.requireNotNull
import org.gradle.api.Project
import org.gradle.api.file.Directory
import org.gradle.api.provider.Provider

fun Project.registerRunTask(
    bowConfiguration: BowConfiguration,
    buildOutputDir: Provider<Directory>,
    bowExtension: BowPluginExtension,
) {
    val capitalizedConfName = bowConfiguration.capitalizedConfName
    tasks.registerBowTask(
        "bowRun${capitalizedConfName}",
        "<TODO>",
    ) { runTask ->

        val buildTask = tasks.getByName("bowBuild${bowConfiguration.capitalizedConfName}")

        val serverProject = bowExtension.entryProjects.serverProject
            .requireNotNull { "Not Configured `bow.entryProjects.server`." }
        val serverRunTask = bowConfiguration.jvmRunTask
            .requireNotNull { "Can not find `${bowConfiguration.jvmBuildTask}` task in $bowConfiguration Configuration." }
            .let {
                when (it) {
                    is JvmRunTask.RunTask -> serverProject.tasks.getByName(it.taskName)
                    is JvmRunTask.Error -> throw IllegalArgumentException(it.message)
                }
            }

        runTask.dependsOn(
            buildTask,
            serverRunTask.apply {
                dependsOn(buildTask)
            },
        )
    }
}
