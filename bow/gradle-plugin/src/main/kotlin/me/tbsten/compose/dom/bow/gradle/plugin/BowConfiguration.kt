package me.tbsten.compose.dom.bow.gradle.plugin

import java.util.Locale

class BowConfiguration(
    val confName: String,
    val jsBuildTask: String,
    val jsBuildOutputDir: String,
    val jvmBuildTask: String?,
    val jvmBuildOutputDir: String?,
    val jvmRunTask: JvmRunTask,
) {
    companion object {
        val Dev =
            BowConfiguration(
                confName = "dev",
                // must be `jsBrowserDevelopmentExecutableDistribution` but its outputs are very big.
                jsBuildTask = "jsBrowserDistribution",
                // must be `dist/js/developmentExecutable` but jsBuildTask is outputs are very big.
                jsBuildOutputDir = "dist/js/productionExecutable",
                jvmBuildTask = null,
                jvmBuildOutputDir = null,
                jvmRunTask = JvmRunTask.RunTask("run"),
            )
        val Prod =
            BowConfiguration(
                confName = "prod",
                jsBuildTask = "jsBrowserDistribution",
                jsBuildOutputDir = "dist/js/productionExecutable",
                jvmBuildTask = "buildFatJar",
                jvmBuildOutputDir = "libs",
                jvmRunTask =
                    JvmRunTask.Error(
                        "Can not run production. Please run `./gradlew bowBuildProd` and `java -jar build/libs/mirrorball-bow-server-output.jar`.",
                    ),
            )
    }

    val capitalizedConfName =
        confName.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
}

sealed interface JvmRunTask {
    class RunTask(
        val taskName: String,
    ) : JvmRunTask

    class Error(
        val message: String,
    ) : JvmRunTask
}
