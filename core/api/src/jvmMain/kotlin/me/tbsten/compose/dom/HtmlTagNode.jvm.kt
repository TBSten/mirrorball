package me.tbsten.compose.dom

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeNode
import androidx.compose.runtime.ReusableComposeNode
import me.tbsten.compose.dom.attributes.AttrsScope
import org.w3c.dom.Element
import org.w3c.dom.Text
import org.xml.sax.InputSource
import java.io.StringReader
import javax.xml.parsers.DocumentBuilderFactory

@Composable
actual fun HtmlTag(
    localName: String,
    attrs: AttrsScope.() -> Unit,
    ref: HtmlTagRef,
    dangerouslySetInnerHTML: String?,
    content: @Composable HtmlTagContentScope.() -> Unit,
) {
    val attrsScope = AttrsScope(ref = ref)
    val scope = HtmlTagContentScope(ref = ref)
    val document = LocalDocument.currentOrThrow

    ComposeNode<Element, JvmDomApplier>(
        factory = {
            document.createElement(localName)
        },
        update = {
            attrsScope.apply(attrs).attrsMap.forEach { (name, value) ->
                set(name to value) { setAttribute(name, value) }
            }
            if (dangerouslySetInnerHTML != null) {
                set(dangerouslySetInnerHTML) {
                    addDangerouslySetInnerHTML(dangerouslySetInnerHTML)
                }
            }
        },
        content = {
            scope.content()
        },
    )
}

@Composable
internal actual fun HtmlText(text: String) {
    val document = LocalDocument.currentOrThrow

    ReusableComposeNode<Text, JvmDomApplier>(
        factory = {
            document.createTextNode("")
        },
        update = {
            set(text) { textContent = it }
        },
    )
}

private fun Element.addDangerouslySetInnerHTML(dangerouslySetInnerHTML: String) {
    val builder =
        DocumentBuilderFactory.newInstance()
            .newDocumentBuilder()
    val inputSource = InputSource(StringReader(dangerouslySetInnerHTML))
    val newDocument = builder.parse(inputSource)
    val importedNode = newDocument.importNode(newDocument.documentElement, true)
    appendChild(importedNode)
}
