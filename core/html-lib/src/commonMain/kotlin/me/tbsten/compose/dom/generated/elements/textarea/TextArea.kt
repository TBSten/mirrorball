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
public fun TextArea(
  attrs: TextAreaAttrsScope.() -> Unit = { },
  ref: HtmlTagRef = rememberDefaultHtmlTagRef(),
  dangerouslySetInnerHTML: String? = null,
  content: @Composable TextAreaContentScope.() -> Unit = { },
) {
  val attrsScope = TextAreaAttrsScope(ref = ref).apply { attrs() }
  val tagContent :  @Composable() (HtmlTagContentScope.() -> Unit) = {
  val scope = TextAreaContentScope(ref)
  scope.content()
  }
  HtmlTag(localName = "textarea", attrs = { applyScope(attrsScope) }, ref = ref, content =
      tagContent,dangerouslySetInnerHTML = dangerouslySetInnerHTML,)
}
