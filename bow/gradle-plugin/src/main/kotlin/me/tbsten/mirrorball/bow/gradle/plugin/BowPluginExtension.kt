package me.tbsten.mirrorball.bow.gradle.plugin

import org.gradle.api.Project
import org.gradle.api.artifacts.ProjectDependency

open class BowPluginExtension {
    internal lateinit var appliedProject: Project
    val entryProjects = BowPluginEntryProjects()
    val configurations =
        mutableListOf<BowConfiguration>(
            BowConfiguration.Dev,
            BowConfiguration.Prod,
        )
}

class BowPluginEntryProjects {
    operator fun invoke(block: BowPluginEntryProjects.() -> Unit) = this.block()

    internal val clientScriptProjects = mutableMapOf<String, ClientScriptProject>()
    internal var serverProject: ServerProject? = null

    @Suppress("unused", "MemberVisibilityCanBePrivate")
    fun clientScript(
        project: Project,
        modulePath: String,
    ) {
        if (clientScriptProjects[modulePath] != null) throw IllegalArgumentException("$modulePath (clientPage project) is already registered")
        clientScriptProjects[modulePath] = ClientScriptProject(project, normalizeModulePath(modulePath))
    }

    @Suppress("unused", "MemberVisibilityCanBePrivate")
    fun clientScript(
        project: ProjectDependency,
        modulePath: String,
    ) {
        clientScript(project.dependencyProject, modulePath)
    }

    @Suppress("unused", "MemberVisibilityCanBePrivate")
    fun server(project: Project) {
        if (serverProject != null) throw IllegalArgumentException("server project is already registered")
        this.serverProject = ServerProject(project)
    }

    @Suppress("unused", "MemberVisibilityCanBePrivate")
    fun server(project: ProjectDependency) {
        server(project.dependencyProject)
    }

    internal class ClientScriptProject(
        project: Project,
        val modulePath: String,
    ) : Project by project

    internal class ServerProject(
        project: Project,
    ) : Project by project
}

private fun normalizeModulePath(modulePath: String): String =
    modulePath
        // 最初と最後の `/` を削除
        .also { it.replace(Regex("^/"), "") }
        .also { it.replace(Regex("/$"), "") }
