// THIS FILE IS AUTO GENERATED .
// DO NOT EDIT THIS FILE .
@file:Suppress(
  "PackageDirectoryMismatch",
  "unused",
)

package me.tbsten.compose.dom.elements

import kotlin.Boolean
import kotlin.String
import kotlin.Suppress
import me.tbsten.compose.dom.HtmlTagRef
import me.tbsten.compose.dom.attributes.AttrsScope
import me.tbsten.compose.dom.attributes.attr

public class FormAttrsScope(
  ref: HtmlTagRef,
) : AttrsScope(ref)

public fun FormAttrsScope.acceptCharset(acceptCharset: String) {
  attr("accept-charset", acceptCharset)
}

public fun FormAttrsScope.autocomplete(autocomplete: FormAutocomplete) {
  attr("autocomplete", autocomplete.enumValue)
}

public enum class FormAutocomplete(
  public val enumValue: String,
) {
  On("on"),
  Off("off"),
  ;
}

public fun FormAttrsScope.name(name: String) {
  attr("name", name)
}

public fun FormAttrsScope.rel(rel: String) {
  attr("rel", rel)
}

public fun FormAttrsScope.action(action: String) {
  attr("action", action)
}

public fun FormAttrsScope.encType(encType: String) {
  attr("enctype", encType)
}

public fun FormAttrsScope.method(method: FormMethod) {
  attr("method", method.enumValue)
}

public enum class FormMethod(
  public val enumValue: String,
) {
  Post("post"),
  Get("get"),
  Dialog("dialog"),
  ;
}

public fun FormAttrsScope.noValidate(noValidate: Boolean) {
  attr("novalidate", noValidate)
}

public fun FormAttrsScope.target(target: FormTarget) {
  attr("target", target.enumValue)
}

public enum class FormTarget(
  public val enumValue: String,
) {
  Self("_self"),
  Blank("_blank"),
  Parent("_parent"),
  Top("_top"),
  ;
}
