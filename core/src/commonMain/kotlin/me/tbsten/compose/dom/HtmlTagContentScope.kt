package me.tbsten.compose.dom

import androidx.compose.runtime.Composable

open class HtmlTagContentScope(val ref: HtmlTagRef) {
    @Composable
    operator fun String.unaryPlus() {
        HtmlText(this)
    }
}
