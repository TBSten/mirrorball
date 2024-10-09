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

    internal val clientPageProjects = mutableMapOf<String, ClientPageProject>()
    internal var serverProject: ServerProject? = null

    @Suppress("unused", "MemberVisibilityCanBePrivate")
    fun clientPage(
        project: Project,
        modulePath: String,
    ) {
        if (clientPageProjects[modulePath] != null) throw IllegalArgumentException("$modulePath (clientPage project) is already registered")
        clientPageProjects[modulePath] = ClientPageProject(project, modulePath)
    }

    @Suppress("unused", "MemberVisibilityCanBePrivate")
    fun clientPage(
        project: ProjectDependency,
        modulePath: String,
    ) {
        clientPage(project.dependencyProject, modulePath)
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

    internal class ClientPageProject(
        project: Project,
        val modulePath: String,
    ) : Project by project

    internal class ServerProject(
        project: Project,
    ) : Project by project
}
