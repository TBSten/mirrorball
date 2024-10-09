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

class ThAttrsScope(
    ref: HtmlTagRef,
) : AttrsScope(ref)

fun ThAttrsScope.abbr(abbr: String) {
    attr("abbr", abbr)
}

fun ThAttrsScope.colspan(colspan: Int) {
    attr("colspan", colspan)
}

fun ThAttrsScope.colspan(colspan: Float) {
    attr("colspan", colspan)
}

fun ThAttrsScope.headers(headers: String) {
    attr("headers", headers)
}

fun ThAttrsScope.rowspan(rowspan: Int) {
    attr("rowspan", rowspan)
}

fun ThAttrsScope.rowspan(rowspan: Float) {
    attr("rowspan", rowspan)
}

fun ThAttrsScope.scope(scope: ThScope) {
    attr("scope", scope.enumValue)
}

enum class ThScope(
    val enumValue: String,
) {
    Row("row"),
    Col("col"),
    RowGroup("rowgroup"),
    ColGroup("colgroup"),
}
