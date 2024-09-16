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
public fun InputPassword(
  attrs: InputPasswordAttrsScope.() -> Unit = { },
  ref: HtmlTagRef = rememberDefaultHtmlTagRef(),
  content: @Composable InputPasswordContentScope.() -> Unit = { },
) {
  val attrsScope = InputPasswordAttrsScope(ref = ref).apply { attrs() }
  val tagContent :  @Composable() (HtmlTagContentScope.() -> Unit) = {
  val scope = InputPasswordContentScope(ref)
  scope.content()
  }
  HtmlTag(localName = "input", attrs = { applyScope(attrsScope) }, ref = ref, content = tagContent,)
}
