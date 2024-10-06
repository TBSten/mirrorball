package util

import org.gradle.api.Project
import org.jlleitschuh.gradle.ktlint.KtlintExtension

fun Project.ktlint(action: KtlintExtension.() -> Unit) {
    extensions.configure(KtlintExtension::class.java, action)
}
