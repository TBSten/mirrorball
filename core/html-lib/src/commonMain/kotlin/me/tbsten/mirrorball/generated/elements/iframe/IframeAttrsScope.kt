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

class IframeAttrsScope(
    ref: HtmlTagRef,
) : AttrsScope(ref)

fun IframeAttrsScope.allow(allow: String) {
    attr("allow", allow)
}

fun IframeAttrsScope.height(height: Int) {
    attr("height", height)
}

fun IframeAttrsScope.height(height: Float) {
    attr("height", height)
}

fun IframeAttrsScope.loading(loading: IframeLoading) {
    attr("loading", loading.enumValue)
}

enum class IframeLoading(
    val enumValue: String,
) {
    Eager("eager"),
    Lazy("lazy"),
}

fun IframeAttrsScope.name(name: String) {
    attr("name", name)
}

fun IframeAttrsScope.referrerPolicy(referrerPolicy: IframeReferrerPolicy) {
    attr("referrerpolicy", referrerPolicy.enumValue)
}

enum class IframeReferrerPolicy(
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

fun IframeAttrsScope.sandbox(sandbox: String) {
    attr("sandbox", sandbox)
}

fun IframeAttrsScope.src(src: String) {
    attr("src", src)
}

fun IframeAttrsScope.srcDoc(srcDoc: String) {
    attr("srcdoc", srcDoc)
}

fun IframeAttrsScope.width(width: Int) {
    attr("width", width)
}

fun IframeAttrsScope.width(width: Float) {
    attr("width", width)
}
