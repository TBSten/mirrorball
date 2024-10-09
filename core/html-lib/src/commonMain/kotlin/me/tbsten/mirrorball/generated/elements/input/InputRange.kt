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
fun InputRange(
    attrs: InputRangeAttrsScope.() -> Unit = { },
    ref: HtmlTagRef = rememberDefaultHtmlTagRef(),
    dangerouslySetInnerHTML: String? = null,
    content: @Composable InputRangeContentScope.() -> Unit = { },
) {
    val attrsScope = InputRangeAttrsScope(ref = ref).apply { attrs() }
    val tagContent:
        @Composable()
        (HtmlTagContentScope.() -> Unit) = {
            val scope = InputRangeContentScope(ref)
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
