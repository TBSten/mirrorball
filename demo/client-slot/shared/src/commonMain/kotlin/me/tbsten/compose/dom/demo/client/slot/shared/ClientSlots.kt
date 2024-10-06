package me.tbsten.compose.dom.demo.client.slot.shared

import kotlinx.serialization.Serializable
import me.tbsten.compose.dom.bow.Slot

@Serializable
data object BasicSlot : Slot

@Serializable
data class SlotWithArgs(
    val str: String,
    val int: Int,
) : Slot
