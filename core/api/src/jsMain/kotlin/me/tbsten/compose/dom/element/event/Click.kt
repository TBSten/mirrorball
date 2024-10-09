package me.tbsten.compose.dom.element.event

import androidx.compose.runtime.Composable
import me.tbsten.compose.dom.HtmlTagContentScope
import org.w3c.dom.events.MouseEvent

@Composable
fun HtmlTagContentScope.onClick(block: (MouseEvent) -> Unit) = onEvent("click", block)
