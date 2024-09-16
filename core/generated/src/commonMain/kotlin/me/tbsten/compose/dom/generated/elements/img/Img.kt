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
public fun Img(
  attrs: ImgAttrsScope.() -> Unit = { },
  ref: HtmlTagRef = rememberDefaultHtmlTagRef(),
  content: @Composable ImgContentScope.() -> Unit = { },
) {
  val attrsScope = ImgAttrsScope(ref = ref).apply { attrs() }
  val tagContent :  @Composable() (HtmlTagContentScope.() -> Unit) = {
  val scope = ImgContentScope(ref)
  scope.content()
  }
  HtmlTag(localName = "img", attrs = { applyScope(attrsScope) }, ref = ref, content = tagContent,)
}
