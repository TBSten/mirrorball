package me.tbsten.mirrorball.styleSheet

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import org.w3c.dom.Document
import org.w3c.dom.HTMLStyleElement
import kotlinx.browser.document as browserDocument

private const val MirrorballStyleTagId = "__mirrorball_styles__"

class JsMirrorballStyleSheet : MirrorballStyleSheet() {
    private fun applyToDocument(document: Document = browserDocument) {
        val mirrorballStyleSheet = this
        val styleTagId = "$MirrorballStyleTagId-${mirrorballStyleSheet.key.value}"
        val styleElement =
            document.getElementById(styleTagId)?.let { it as? HTMLStyleElement }
                ?: document.createElement("style").apply {
                    id = styleTagId
                } as HTMLStyleElement

        styleElement.apply {
            innerHTML = mirrorballStyleSheet.toString()
        }

        document.head!!.appendChild(styleElement)
    }

    @Composable
    fun CollectUpdate(document: Document = browserDocument) {
        LaunchedEffect(document) {
            onUpdate.collect {
                applyToDocument(document)
            }
        }
    }
}
