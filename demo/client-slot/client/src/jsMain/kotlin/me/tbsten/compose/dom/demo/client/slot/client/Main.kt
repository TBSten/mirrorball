package me.tbsten.compose.dom.demo.client.slot.client

import kotlinx.browser.window
import me.tbsten.compose.dom.bow.generated.injectClientSlots

fun main() {
    window.addEventListener("load", {
        injectClientSlots()
    })
}
