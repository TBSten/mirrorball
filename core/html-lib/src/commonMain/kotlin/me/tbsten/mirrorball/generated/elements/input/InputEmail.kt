// THIS FILE IS AUTO GENERATED .
// DO NOT EDIT THIS FILE .
@file:Suppress(
    "PackageDirectoryMismatch",
    "unused",
)

package me.tbsten.mirrorball.elements

import androidx.compose.runtime.Composable
import me.tbsten.mirrorball.HtmlTag
import me.tbsten.mirrorball.HtmlTagContentScope
import me.tbsten.mirrorball.HtmlTagRef
import me.tbsten.mirrorball.rememberDefaultHtmlTagRef
import kotlin.String
import kotlin.Suppress
import kotlin.Unit

@Composable
fun InputEmail(
    attrs: InputEmailAttrsScope.() -> Unit = { },
    ref: HtmlTagRef = rememberDefaultHtmlTagRef(),
    dangerouslySetInnerHTML: String? = null,
    content: @Composable InputEmailContentScope.() -> Unit = { },
) {
    val attrsScope = InputEmailAttrsScope(ref = ref).apply { attrs() }
    val tagContent:
        @Composable()
        (HtmlTagContentScope.() -> Unit) = {
            val scope = InputEmailContentScope(ref)
            scope.content()
        }
    HtmlTag(
        localName = "input",
        attrs = { applyScope(attrsScope) },
        ref = ref,
        content =
        tagContent,
        dangerouslySetInnerHTML = dangerouslySetInnerHTML,
    )
}
