package me.tbsten.mirrorball.bow.gradle.plugin

import me.tbsten.mirrorball.bow.gradle.plugin.util.requireNotNull
import org.gradle.api.Plugin
import org.gradle.api.Project

@Suppress("unused")
open class BowPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            val bowExtension =
                extensions
                    .create(
                        "bow",
                        BowPluginExtension::class.java,
                    ).apply { appliedProject = project }

            afterEvaluate {
                bowExtension.configurations.forEach { conf ->
                    val buildOutputDir =
                        layout.buildDirectory
                            .dir("bow/${conf.confName}")

                    val serverProject =
                        bowExtension.entryProjects.serverProject
                            .requireNotNull { "Not configured `bow.entryProjects.server`" }
                    serverProject.afterEvaluate {
                        serverProject.pluginManager.apply(BowServerPlugin::class.java)
                    }

                    registerBuildTask(conf, buildOutputDir, bowExtension)
                    registerRunTask(conf, buildOutputDir, bowExtension)
                }
            }
        }
    }
}
