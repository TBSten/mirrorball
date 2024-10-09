package me.tbsten.mirrorball.demo.client.slot.shared

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import me.tbsten.mirrorball.bow.SerializableComposableLambda
import me.tbsten.mirrorball.bow.slot.Slot

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
