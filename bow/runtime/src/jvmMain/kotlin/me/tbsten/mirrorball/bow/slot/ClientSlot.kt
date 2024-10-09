package me.tbsten.mirrorball.bow.slot

import androidx.compose.runtime.Composable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import me.tbsten.mirrorball.attributes.hidden
import me.tbsten.mirrorball.attributes.id
import me.tbsten.mirrorball.bow.defaultBowJson
import me.tbsten.mirrorball.elements.Div
import me.tbsten.mirrorball.elements.Script

@Composable
inline fun <reified S : Slot> ClientSlot(
    slot: S,
    json: Json = defaultBowJson(),
) {
    val slotClassName =
        S::class.qualifiedName
            ?: throw IllegalArgumentException("Client Slot qualifiedName is null")
    val id = "--bow-client-slot-$slotClassName"
    val slotArgsId = "--bow-client-slot-args-$slotClassName"

    Div(attrs = { id(id) })

    Script(attrs = {
        id(slotArgsId)
        hidden(true)
        attr("type", "application/json")
    }) {
        +json.encodeToString(slot)
    }
}
