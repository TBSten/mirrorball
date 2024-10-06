package me.tbsten.compose.dom.bow.client

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.browser.document
import kotlinx.browser.window
import me.tbsten.compose.dom.element.event.onClick
import me.tbsten.compose.dom.elements.Button
import me.tbsten.compose.dom.elements.Div
import me.tbsten.compose.dom.renderComposable
import org.w3c.dom.HTMLElement


fun main() {
    window.addEventListener("load", {
        console.log("demo:bow:client")
        (document.getElementById("root") as HTMLElement)
            .renderComposable {
                var count by remember { mutableStateOf(0) }
                Div {
                    +"$count"
                    Button {
                        onClick { count++ }
                        +"client button"
                    }
                }
            }
    })
}
