// THIS FILE IS AUTO GENERATED .
// DO NOT EDIT THIS FILE .
@file:Suppress(
  "PackageDirectoryMismatch",
  "unused",
)

package me.tbsten.compose.dom.elements

import androidx.compose.runtime.Composable
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import me.tbsten.compose.dom.HtmlTag
import me.tbsten.compose.dom.HtmlTagContentScope
import me.tbsten.compose.dom.HtmlTagRef
import me.tbsten.compose.dom.rememberDefaultHtmlTagRef

@Composable
public fun Col(
  attrs: ColAttrsScope.() -> Unit = { },
  ref: HtmlTagRef = rememberDefaultHtmlTagRef(),
  dangerouslySetInnerHTML: String? = null,
  content: @Composable ColContentScope.() -> Unit = { },
) {
  val attrsScope = ColAttrsScope(ref = ref).apply { attrs() }
  val tagContent :  @Composable() (HtmlTagContentScope.() -> Unit) = {
  val scope = ColContentScope(ref)
  scope.content()
  }
  HtmlTag(localName = "col", attrs = { applyScope(attrsScope) }, ref = ref, content =
      tagContent,dangerouslySetInnerHTML = dangerouslySetInnerHTML,)
}
