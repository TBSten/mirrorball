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

class TemplateAttrsScope(
    ref: HtmlTagRef,
) : AttrsScope(ref)

fun TemplateAttrsScope.shadowRootMode(shadowRootMode: TemplateShadowRootMode) {
    attr("shadowrootmode", shadowRootMode.enumValue)
}

enum class TemplateShadowRootMode(
    val enumValue: String,
) {
    Open("open"),
    Closed("closed"),
}

fun TemplateAttrsScope.shadowRootClonable(shadowRootClonable: Boolean) {
    attr("shadowrootclonable", shadowRootClonable)
}

fun TemplateAttrsScope.shadowRootDelegatesFocus(shadowRootDelegatesFocus: Boolean) {
    attr("shadowrootdelegatesfocus", shadowRootDelegatesFocus)
}
