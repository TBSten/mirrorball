package me.tbsten.compose.dom.generate.elements

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import me.tbsten.compose.dom.generate.Element
import me.tbsten.compose.dom.generate.definition.elements
import java.io.File

/**
 * generateDirectory/elements/<element> ディレクトリにcomponentのファイルを生成する。
 */
suspend fun generateElementsFiles(
    generateDirectory: File,
) = coroutineScope {
    elements.map { element ->
        launch {
            generateElementFiles(
                element,
                generateDirectory,
            )
        }
    }.joinAll()
}

private suspend fun generateElementFiles(
    element: Element,
    generateDirectory: File,
) {
    val composableName = element.kotlinName
    val htmlName = element.elementName
    val packageName = element.elementName

    val packageDir = File(generateDirectory, "elements/$packageName")

    listOf(
        elementComposableFile(composableName, htmlName) to File(packageDir, "$composableName.kt"),
        elementAttrsScopeFile(
            composableName,
            initialAttrs = element.initialAttrs,
            attrs = element.attrs
        ) to File(packageDir, "${composableName}AttrsScope.kt"),
        elementContentScopeFile(composableName) to File(
            packageDir,
            "${composableName}ContentScope.kt"
        ),
    ).forEach { (fileSpec, file) ->
        if (!file.parentFile.exists()) file.parentFile.mkdirs()
        file.createNewFile()
        file.bufferedWriter().use {
            println("GEN ${fileSpec.name}")
            it.write(
                fileSpec
                    .build()
                    .toString()
            )
        }
    }
}
