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
import kotlin.Boolean
import kotlin.String
import kotlin.Suppress

class ScriptAttrsScope(
    ref: HtmlTagRef,
) : AttrsScope(ref)

fun ScriptAttrsScope.async(async: Boolean) {
    attr("async", async)
}

fun ScriptAttrsScope.crossOrigin(crossOrigin: ScriptCrossOrigin) {
    attr("crossorigin", crossOrigin.enumValue)
}

enum class ScriptCrossOrigin(
    val enumValue: String,
) {
    Anonymous("anonymous"),
    UseCredentials("use-credentials"),
}

fun ScriptAttrsScope.defer(defer: Boolean) {
    attr("defer", defer)
}

fun ScriptAttrsScope.integrity(integrity: String) {
    attr("integrity", integrity)
}

fun ScriptAttrsScope.noModule(noModule: Boolean) {
    attr("nomodule", noModule)
}

fun ScriptAttrsScope.nonce(nonce: String) {
    attr("nonce", nonce)
}

fun ScriptAttrsScope.referrerPolicy(referrerPolicy: ScriptReferrerPolicy) {
    attr("referrerpolicy", referrerPolicy.enumValue)
}

enum class ScriptReferrerPolicy(
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

fun ScriptAttrsScope.src(src: String) {
    attr("src", src)
}

fun ScriptAttrsScope.type(type: ScriptType) {
    attr("type", type.enumValue)
}

enum class ScriptType(
    val enumValue: String,
) {
    TextJavaScript("text/javascript"),
    Module("module"),
    importmap("ImportMap"),
}
