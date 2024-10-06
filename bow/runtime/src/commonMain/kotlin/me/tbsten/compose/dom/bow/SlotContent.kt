package me.tbsten.compose.dom.bow

import androidx.compose.runtime.Composable

interface Slot

interface SlotContent<S : Slot> {
    @Composable
    fun Content(arg: S)
}
