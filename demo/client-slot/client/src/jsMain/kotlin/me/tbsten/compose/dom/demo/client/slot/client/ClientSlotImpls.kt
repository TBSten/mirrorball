package me.tbsten.compose.dom.demo.client.slot.client

import androidx.compose.runtime.Composable
import me.tbsten.compose.dom.bow.slot.MirrorballSlotImplementation
import me.tbsten.compose.dom.demo.client.slot.shared.BasicSlot
import me.tbsten.compose.dom.demo.client.slot.shared.SlotWithArgs
import me.tbsten.compose.dom.demo.client.slot.shared.SlotWithComposableArg
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

@MirrorballSlotImplementation(SlotWithComposableArg::class)
@Composable
fun SlotWithComposableArgImpl(slot: SlotWithComposableArg) {
    Div {
        slot.renderResult.content()
    }
}
