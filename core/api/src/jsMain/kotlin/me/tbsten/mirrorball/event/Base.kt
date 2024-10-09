package me.tbsten.mirrorball.element.event

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import me.tbsten.mirrorball.HtmlTagContentScope
import me.tbsten.mirrorball.currentElement
import org.w3c.dom.events.Event

@Composable
inline fun <reified E : Event> HtmlTagContentScope.onEvent(
    eventName: String,
    crossinline block: (E) -> Unit,
) {
    DisposableEffect(this.ref, eventName) {
        val element = ref.currentElement ?: return@DisposableEffect onDispose { }
        val handler: (Event) -> Unit = { e: Event ->
            (e as? E)?.let(block)
        }
        element.addEventListener(eventName, handler)
        onDispose {
            element.removeEventListener(eventName, handler)
        }
    }
}
