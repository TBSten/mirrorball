package me.tbsten.mirrorball

import androidx.compose.runtime.Composable
import me.tbsten.mirrorball.attributes.AttrsScope

@Composable
expect fun HtmlTag(
    localName: String,
    attrs: AttrsScope.() -> Unit = { },
    ref: HtmlTagRef = rememberDefaultHtmlTagRef(),
    dangerouslySetInnerHTML: String? = null,
    content: @Composable HtmlTagContentScope.() -> Unit = {},
)

@Composable
internal expect fun HtmlText(text: String)
