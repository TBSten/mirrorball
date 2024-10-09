package me.tbsten.mirrorball.element.event

import androidx.compose.runtime.Composable
import me.tbsten.mirrorball.HtmlTagContentScope
import org.w3c.dom.events.MouseEvent

@Composable
fun HtmlTagContentScope.onClick(block: (MouseEvent) -> Unit) = onEvent("click", block)
