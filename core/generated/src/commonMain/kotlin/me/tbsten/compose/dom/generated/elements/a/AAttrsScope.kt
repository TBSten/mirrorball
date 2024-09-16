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

public class AAttrsScope(
  ref: HtmlTagRef,
) : AttrsScope(ref)

public fun AAttrsScope.download(download: Boolean) {
  attr("download", download)
}

public fun AAttrsScope.download(download: String) {
  attr("download", download)
}

public fun AAttrsScope.href(href: String) {
  attr("href", href)
}

public fun AAttrsScope.hrefLang(hrefLang: String) {
  attr("hreflang", hrefLang)
}

public fun AAttrsScope.ping(ping: String) {
  attr("ping", ping)
}

public fun AAttrsScope.referrerPolicy(referrerPolicy: AReferrerPolicy) {
  attr("referrerpolicy", referrerPolicy.enumValue)
}

public enum class AReferrerPolicy(
  public val enumValue: String,
) {
  NoReferrer("no-referrer"),
  NoReferrerWHenDowngrade("no-referrer-when-downgrade"),
  Origin("origin"),
  OriginWhenCrossOrigin("origin-when-cross-origin"),
  SameOrigin("same-origin"),
  StrictOrigin("strict-origin"),
  StrictOriginWhenCrossOrigin("strict-origin-when-cross-origin"),
  UnsafeUrl("unsafe-url"),
  ;
}

public fun AAttrsScope.rel(rel: String) {
  attr("rel", rel)
}

public fun AAttrsScope.target(target: ATarget) {
  attr("target", target.enumValue)
}

public enum class ATarget(
  public val enumValue: String,
) {
  _self("_self"),
  _blank("_blank"),
  _parent("_parent"),
  _top("_top"),
  ;
}

public fun AAttrsScope.target(target: String) {
  attr("target", target)
}

public fun AAttrsScope.type(type: String) {
  attr("type", type)
}
