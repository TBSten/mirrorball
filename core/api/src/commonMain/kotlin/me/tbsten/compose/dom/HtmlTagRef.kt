package me.tbsten.compose.dom

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

class HtmlTagRef {
    private var currentOrNull: Any? = null

    @PublishedApi
    internal fun set(value: Any) {
        currentOrNull = value
    }

    val current
        get() =
            requireNotNull(currentOrNull) {
                "can not access element before init ref. Did you forget to pass the ref ?"
            }
}

@Composable
fun rememberDefaultHtmlTagRef(): HtmlTagRef = remember { HtmlTagRef() }
