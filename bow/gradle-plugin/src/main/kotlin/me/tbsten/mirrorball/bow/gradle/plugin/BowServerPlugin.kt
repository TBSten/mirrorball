package me.tbsten.mirrorball.bow.gradle.plugin

import me.tbsten.mirrorball.bow.gradle.plugin.util.fatJar
import me.tbsten.mirrorball.bow.gradle.plugin.util.kotlinJvm
import me.tbsten.mirrorball.bow.gradle.plugin.util.ktor
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

@Suppress("unused")
open class BowServerPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            // add sourceDir `build/bow/`
            val isKotlinMultiplatformProject = extensions.findByType(KotlinMultiplatformExtension::class.java) != null
            val isKotlinJvm = extensions.findByType(KotlinJvmProjectExtension::class.java) != null

            val kotlin =
                when {
                    isKotlinMultiplatformProject -> ::kotlinJvm
                    isKotlinJvm -> ::kotlinJvm
                    else -> throw IllegalStateException("project ${target.path} is not applied kotlin-jvm or kotlin-multiplatform")
                }

            kotlin {
                sourceSets.forEach { sourceSet ->
                    require(sourceSet is KotlinSourceSet) { "sourceSet must be kotlinSourceSet, but it is ${sourceSet::class.qualifiedName}" }
                    sourceSet.kotlin.srcDir("build/bow/buildInfo")
                }
            }

            // ktor settings
            ktor {
                fatJar {
                    archiveFileName.set("mirrorball-bow-server-output.jar")
                }
            }
        }
    }
}
