package me.tbsten.mirrorball.bow.slot

import androidx.compose.runtime.Composable
import kotlinx.browser.document
import kotlinx.serialization.json.Json
import me.tbsten.mirrorball.bow.defaultBowJson
import me.tbsten.mirrorball.renderComposable
import org.w3c.dom.HTMLElement

inline fun <reified S : Slot> injectSlotImpl(
    slotClassName: String,
    json: Json? = null,
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
        val decodeFormat = json ?: defaultBowJson()
        impl(decodeFormat.decodeFromString<S>(slotArgsElement.innerHTML))
    }
}
