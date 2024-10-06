package me.tbsten.compose.dom.demo.client.slot.shared

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import me.tbsten.compose.dom.bow.SerializableComposableLambda
import me.tbsten.compose.dom.bow.slot.Slot

@Serializable
data object BasicSlot : Slot

@Serializable
data class SlotWithArgs(
    val str: String,
    val int: Int,
) : Slot

@Serializable
data class SlotWithComposableArg(
    val renderResult: @Contextual SerializableComposableLambda,
) : Slot
