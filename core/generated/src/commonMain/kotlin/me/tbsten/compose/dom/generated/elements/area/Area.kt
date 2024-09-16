// THIS FILE IS AUTO GENERATED .
// DO NOT EDIT THIS FILE .
@file:Suppress(
  "PackageDirectoryMismatch",
  "unused",
)

package me.tbsten.compose.dom.elements

import androidx.compose.runtime.Composable
import kotlin.Suppress
import kotlin.Unit
import me.tbsten.compose.dom.HtmlTag
import me.tbsten.compose.dom.HtmlTagContentScope
import me.tbsten.compose.dom.HtmlTagRef
import me.tbsten.compose.dom.rememberDefaultHtmlTagRef

@Composable
public fun Area(
  attrs: AreaAttrsScope.() -> Unit = { },
  ref: HtmlTagRef = rememberDefaultHtmlTagRef(),
  content: @Composable AreaContentScope.() -> Unit = { },
) {
  val attrsScope = AreaAttrsScope(ref = ref).apply { attrs() }
  val tagContent :  @Composable() (HtmlTagContentScope.() -> Unit) = {
  val scope = AreaContentScope(ref)
  scope.content()
  }
  HtmlTag(localName = "area", attrs = { applyScope(attrsScope) }, ref = ref, content = tagContent,)
}
