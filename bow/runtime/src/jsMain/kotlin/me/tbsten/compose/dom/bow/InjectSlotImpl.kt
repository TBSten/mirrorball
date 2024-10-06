package me.tbsten.compose.dom.bow

import androidx.compose.runtime.Composable
import kotlinx.browser.document
import kotlinx.serialization.json.Json
import me.tbsten.compose.dom.renderComposable
import org.w3c.dom.HTMLElement

inline fun <reified S : Slot> injectSlotImpl(
    slotClassName: String,
    crossinline impl: @Composable (args: S) -> Unit,
) {
    val slotElementId = "--bow-client-slot-$slotClassName"
    val slotArgsElementId = "--bow-client-slot-args-$slotClassName"

    val slotElement =
        requireNotNull(document.getElementById(slotElementId)) {
            "Can not find slot element of $slotElementId"
        }
    val slotArgsElement =
        requireNotNull(document.getElementById(slotArgsElementId)) {
            "Can not find slot args element of $slotArgsElementId"
        }
    (slotElement as HTMLElement).renderComposable {
        impl(Json.decodeFromString<S>(slotArgsElement.innerHTML))
    }
}
