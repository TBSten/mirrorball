package me.tbsten.compose.dom.demo

import androidx.compose.runtime.*
import kotlinx.browser.document
import kotlinx.browser.window
import me.tbsten.compose.dom.HtmlTag
import me.tbsten.compose.dom.currentElement
import me.tbsten.compose.dom.element.event.onClick
import me.tbsten.compose.dom.element.event.onEvent
import me.tbsten.compose.dom.elements.button.Button
import me.tbsten.compose.dom.elements.div.Div
import me.tbsten.compose.dom.rememberDefaultHtmlTagRef
import me.tbsten.compose.dom.renderComposable
import org.w3c.dom.Element
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.PopStateEvent
import org.w3c.dom.events.Event
import kotlin.random.Random

fun main() {
    console.log("root", document.getElementById("root"))
    val root = document.getElementById("root") as HTMLElement

    root.renderComposable {
        CounterExampleScreen()
        Div { +"---" }
        TextFieldExampleScreen()
    }
}

@Composable
private fun CounterExampleScreen() {
    var counter by remember { mutableIntStateOf(0) }

    Div {
        +"$counter"

        Div {
            Button(
                attrs = { },
            ) {
                onClick { counter++ }
                +"count up"
            }

            Button(
                attrs = { },
            ) {
                onClick { counter-- }
                +"count down"
            }
        }
    }
}

@Composable
fun Input(
    value: String,
    onChange: (String) -> Unit,
) {
    val currentValue by rememberUpdatedState(value)
    val currentOnChange by rememberUpdatedState(onChange)

    HtmlTag(
        localName = "input",
        attrs = {
            attr("type", "text")
            prop {
                val element = ref.currentElement as HTMLInputElement
                element.value = currentValue
            }
        },
        ref = rememberDefaultHtmlTagRef(),
    ) {
        onEvent<Event>("input") {
            val newValue = it.target.asDynamic().value as String
            currentOnChange(newValue)
            ref.currentElement.asDynamic().value = currentValue
        }
    }
}
