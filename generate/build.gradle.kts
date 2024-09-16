plugins {
    alias(libs.plugins.kotlinJvm)
    application

    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
}

application {
    mainClass = "me.tbsten.compose.dom.generate.MainKt"
}

dependencies {
    implementation(libs.kotlinx.coroutines)
    implementation(libs.kotlin.poet)
    implementation(compose.runtime)
    implementation(projects.core.api)
}

tasks.named<JavaExec>("run") {
    val generateDir =
        File(
            rootProject.layout.projectDirectory.asFile,
            "core/generated/src/commonMain/kotlin/me/tbsten/compose/dom/generated/",
        )
    args = listOf(generateDir.toString())  // ここに引数をリスト形式で指定
}