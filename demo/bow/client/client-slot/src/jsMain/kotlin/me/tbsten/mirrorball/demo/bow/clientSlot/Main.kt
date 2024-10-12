package me.tbsten.mirrorball.demo.bow.clientSlot

import kotlinx.browser.window
import me.tbsten.mirrorball.bow.generated.injectClientSlots

fun main() {
    window.addEventListener("load", {
        injectClientSlots()
    })
}
