package me.tbsten.compose.dom.bow.gradle.plugin

import me.tbsten.compose.dom.bow.gradle.plugin.util.fatJar
import me.tbsten.compose.dom.bow.gradle.plugin.util.ktor
import org.gradle.api.Plugin
import org.gradle.api.Project

@Suppress("unused")
open class BowServerPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            ktor {
                fatJar {
                    archiveFileName.set("mirrorball-bow-server-output.jar")
                }
            }
        }
    }
}
