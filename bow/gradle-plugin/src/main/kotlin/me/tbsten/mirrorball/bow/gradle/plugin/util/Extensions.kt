package me.tbsten.mirrorball.bow.gradle.plugin.util

import com.google.devtools.ksp.gradle.KspExtension
import io.ktor.plugin.features.FatJarExtension
import io.ktor.plugin.features.KtorExtension
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

fun Project.kotlin(action: KotlinMultiplatformExtension.() -> Unit) {
    project.extensions.configure(KotlinMultiplatformExtension::class.java, action)
}

fun Project.ksp(action: KspExtension.() -> Unit) {
    project.extensions.configure(KspExtension::class.java, action)
}

fun Project.ktor(action: KtorExtension.() -> Unit) {
    project.extensions.configure(KtorExtension::class.java, action)
}

fun Project.fatJar(action: FatJarExtension.() -> Unit) {
    val ktorExtension = extensions.findByType(KtorExtension::class.java) as ExtensionAware
    val fatJarExtension = ktorExtension.extensions.getByType(FatJarExtension::class.java)
    fatJarExtension.apply(action)
}
