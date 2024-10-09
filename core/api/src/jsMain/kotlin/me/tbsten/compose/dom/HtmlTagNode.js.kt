package me.tbsten.compose.dom

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeNode
import androidx.compose.runtime.ReusableComposeNode
import kotlinx.browser.document
import me.tbsten.compose.dom.attributes.AttrsScope
import org.w3c.dom.Element
import org.w3c.dom.Text

@Composable
actual fun HtmlTag(
    localName: String,
    attrs: AttrsScope.() -> Unit,
    ref: HtmlTagRef,
    dangerouslySetInnerHTML: String?,
    content: @Composable HtmlTagContentScope.() -> Unit,
) {
    val attrsScope =
        AttrsScope(ref = ref)
            .apply { attrs() }
    val contentScope = HtmlTagContentScope(ref)

    ComposeNode<Element, JsDomApplier>(
        factory = {
            document.createElement(localName)
                .also { element ->
                    ref.set(element)
                }
        },
        update = {
            attrsScope.attrsMap.forEach { (name, value) ->
                set(name to value) {
                    setAttribute(name, value)
                }
            }
            attrsScope.updaters.forEach { updater ->
                reconcile {
                    updater(ref)
                }
            }
            if (dangerouslySetInnerHTML != null) {
                set(dangerouslySetInnerHTML) {
                    this.innerHTML = dangerouslySetInnerHTML
                }
            }
        },
        content = {
            contentScope.content()
        },
    )
}

@Composable
internal actual fun HtmlText(text: String) {
    ReusableComposeNode<Text, JsDomApplier>(
        factory = {
            document.createTextNode("")
        },
        update = {
            set(text) { textContent = it }
        },
    )
}
