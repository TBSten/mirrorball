package me.tbsten.compose.dom.demo.client.slot.client

import androidx.compose.runtime.Composable
import me.tbsten.compose.dom.bow.MirrorballSlotImplementation
import me.tbsten.compose.dom.demo.client.slot.shared.BasicSlot
import me.tbsten.compose.dom.demo.client.slot.shared.SlotWithArgs
import me.tbsten.compose.dom.elements.Div

@MirrorballSlotImplementation(BasicSlot::class)
@Composable
fun BasicSlotImpl(slot: BasicSlot) {
    Div {
        Div { +"SlotWithArgsImpl" }
        Div { +"this render on client" }
    }
}

@MirrorballSlotImplementation(SlotWithArgs::class)
@Composable
fun SlotWithArgsImpl(slot: SlotWithArgs) {
    Div {
        Div { +"SlotWithArgsImpl" }
        Div { +slot.str }
        Div { +"${slot.int}" }
    }
}
