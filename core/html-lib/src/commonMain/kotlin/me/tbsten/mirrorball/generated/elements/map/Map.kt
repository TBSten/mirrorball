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
fun Map(
    attrs: MapAttrsScope.() -> Unit = { },
    ref: HtmlTagRef = rememberDefaultHtmlTagRef(),
    dangerouslySetInnerHTML: String? = null,
    content: @Composable MapContentScope.() -> Unit = { },
) {
    val attrsScope = MapAttrsScope(ref = ref).apply { attrs() }
    val tagContent:
        @Composable()
        (HtmlTagContentScope.() -> Unit) = {
            val scope = MapContentScope(ref)
            scope.content()
        }
    HtmlTag(
        localName = "map",
        attrs = { applyScope(attrsScope) },
        ref = ref,
        content =
        tagContent,
        dangerouslySetInnerHTML = dangerouslySetInnerHTML,
    )
}
