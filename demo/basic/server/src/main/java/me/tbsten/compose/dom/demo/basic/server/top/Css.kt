package me.tbsten.compose.dom.demo.basic.server.top

import kotlinx.css.Color
import kotlinx.css.CssBuilder
import kotlinx.css.Margin
import kotlinx.css.Padding
import kotlinx.css.backgroundColor
import kotlinx.css.margin
import kotlinx.css.padding
import kotlinx.css.px

internal fun CssBuilder.topPageCss() {
    rule("html, body") {
        padding = Padding(0.px)
        margin = Margin(0.px)
        backgroundColor = Color("#00FF00")
    }
}
