package me.tbsten.compose.dom.bow.gradle.plugin

import org.gradle.api.Action
import org.gradle.api.Task
import org.gradle.api.tasks.TaskContainer

const val GroupId = "me.tbsten.compose.dom"

internal fun TaskContainer.registerBowTask(
    name: String,
    description: String,
    configurationAction: Action<in Task>,
) =
    register(name) {
        it.group = GroupId
        it.description = description
        configurationAction.execute(it)
    }
