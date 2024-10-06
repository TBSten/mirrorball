package me.tbsten.compose.dom.bow.client.top

import kotlinx.browser.document

fun main() {
    document.getElementById("top-element")!!.innerHTML = "top-page"
}
