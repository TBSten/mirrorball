package util

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension

val Project.libs
    get(): VersionCatalog = extensions.getByType(VersionCatalogsExtension::class.java).named("libs")

fun VersionCatalog.version(id: String) =
    findVersion(id).get().strictVersion
