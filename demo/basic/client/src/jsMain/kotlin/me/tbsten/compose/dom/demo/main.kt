package me.tbsten.compose.dom.demo

import kotlinx.browser.document
import me.tbsten.compose.dom.elements.Div
import me.tbsten.compose.dom.renderComposable
import org.w3c.dom.HTMLElement

fun main() {
    console.log("root", document.getElementById("root"))
    val root = document.getElementById("root") as HTMLElement

    root.renderComposable {
        CounterExampleScreen()
        Div { +"---" }
        TextFieldExampleScreen()
        Div { +"---" }
        Div { +"kotlin: ${KotlinVersion.CURRENT}" }
    }
}
