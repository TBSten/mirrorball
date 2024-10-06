import org.gradle.api.Plugin
import org.gradle.api.Project
import primitive.KtlintConventionPlugin

class KspPluginConvensionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply(KtlintConventionPlugin::class.java)
        }
    }
}
