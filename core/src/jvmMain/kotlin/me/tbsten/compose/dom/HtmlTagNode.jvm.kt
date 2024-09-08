package me.tbsten.compose.dom

import androidx.compose.runtime.*
import me.tbsten.compose.dom.attributes.AttrsScope
import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.Text

@Composable
actual fun HtmlTag(
    localName: String,
    attrs: AttrsScope.() -> Unit,
    ref: HtmlTagRef,
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