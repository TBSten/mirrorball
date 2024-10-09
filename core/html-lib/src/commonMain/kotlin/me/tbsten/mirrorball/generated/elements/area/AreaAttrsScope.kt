// THIS FILE IS AUTO GENERATED .
// DO NOT EDIT THIS FILE .
@file:Suppress(
    "PackageDirectoryMismatch",
    "unused",
)

package me.tbsten.mirrorball.elements

import me.tbsten.mirrorball.HtmlTagRef
import me.tbsten.mirrorball.attributes.AttrsScope
import me.tbsten.mirrorball.attributes.attr
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.Suppress

class AreaAttrsScope(
    ref: HtmlTagRef,
) : AttrsScope(ref)

fun AreaAttrsScope.alt(alt: String) {
    attr("alt", alt)
}

fun AreaAttrsScope.coords(coords: Int) {
    attr("coords", coords)
}

fun AreaAttrsScope.coords(coords: Float) {
    attr("coords", coords)
}

fun AreaAttrsScope.download(download: String) {
    attr("download", download)
}

fun AreaAttrsScope.href(href: String) {
    attr("href", href)
}

fun AreaAttrsScope.hrefLang(hrefLang: String) {
    attr("hreflang", hrefLang)
}

fun AreaAttrsScope.ping(ping: String) {
    attr("ping", ping)
}

fun AreaAttrsScope.referrerPolicy(referrerPolicy: AreaReferrerPolicy) {
    attr("referrerpolicy", referrerPolicy.enumValue)
}

enum class AreaReferrerPolicy(
    val enumValue: String,
) {
    NoReferrer("no-referrer"),
    NoReferrerWHenDowngrade("no-referrer-when-downgrade"),
    Origin("origin"),
    OriginWhenCrossOrigin("origin-when-cross-origin"),
    SameOrigin("same-origin"),
    StrictOrigin("strict-origin"),
    StrictOriginWhenCrossOrigin("strict-origin-when-cross-origin"),
    UnsafeUrl("unsafe-url"),
}

fun AreaAttrsScope.rel(rel: String) {
    attr("rel", rel)
}

fun AreaAttrsScope.shape(shape: String) {
    attr("shape", shape)
}

fun AreaAttrsScope.target(target: AreaTarget) {
    attr("target", target.enumValue)
}

enum class AreaTarget(
    val enumValue: String,
) {
    _self("_self"),
    _blank("_blank"),
    _parent("_parent"),
    _top("_top"),
}
