// THIS FILE IS AUTO GENERATED .
// DO NOT EDIT THIS FILE .
@file:Suppress(
  "PackageDirectoryMismatch",
  "unused",
)

package me.tbsten.compose.dom.elements

import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import me.tbsten.compose.dom.HtmlTagRef
import me.tbsten.compose.dom.attributes.AttrsScope
import me.tbsten.compose.dom.attributes.attr

public class ThAttrsScope(
  ref: HtmlTagRef,
) : AttrsScope(ref)

public fun ThAttrsScope.abbr(abbr: String) {
  attr("abbr", abbr)
}

public fun ThAttrsScope.colspan(colspan: Int) {
  attr("colspan", colspan)
}

public fun ThAttrsScope.colspan(colspan: Float) {
  attr("colspan", colspan)
}

public fun ThAttrsScope.headers(headers: String) {
  attr("headers", headers)
}

public fun ThAttrsScope.rowspan(rowspan: Int) {
  attr("rowspan", rowspan)
}

public fun ThAttrsScope.rowspan(rowspan: Float) {
  attr("rowspan", rowspan)
}

public fun ThAttrsScope.scope(scope: ThScope) {
  attr("scope", scope.enumValue)
}

public enum class ThScope(
  public val enumValue: String,
) {
  Row("row"),
  Col("col"),
  RowGroup("rowgroup"),
  ColGroup("colgroup"),
  ;
}
