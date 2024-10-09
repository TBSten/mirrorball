package me.tbsten.mirrorball.demo.client.slot.client

import kotlinx.browser.window
import me.tbsten.mirrorball.bow.generated.injectClientSlots

fun main() {
    window.addEventListener("load", {
        injectClientSlots()
    })
}
