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

class InputAttrsScope(
    ref: HtmlTagRef,
) : AttrsScope(ref)

fun InputAttrsScope.type(type: String) {
    attr("type", type)
}

fun InputAttrsScope.disabled(disabled: Boolean) {
    attr("disabled", disabled)
}

fun InputAttrsScope.form(form: String) {
    attr("form", form)
}

fun InputAttrsScope.name(name: String) {
    attr("name", name)
}

fun InputAttrsScope.`value`(`value`: String) {
    attr("value", value)
}
