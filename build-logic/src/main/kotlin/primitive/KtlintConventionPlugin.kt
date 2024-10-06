package primitive

import org.gradle.api.Plugin
import org.gradle.api.Project
import util.ktlint

class KtlintConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("org.jlleitschuh.gradle.ktlint")

            ktlint {
//                version.set(libs.version("ktlint"))
            }
        }
    }
}
