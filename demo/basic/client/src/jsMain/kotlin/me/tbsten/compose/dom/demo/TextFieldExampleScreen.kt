package me.tbsten.compose.dom.demo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import me.tbsten.compose.dom.HtmlTag
import me.tbsten.compose.dom.currentElement
import me.tbsten.compose.dom.element.event.onEvent
import me.tbsten.compose.dom.elements.Div
import me.tbsten.compose.dom.rememberDefaultHtmlTagRef
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.events.Event


// client code
@Composable
fun TextFieldExampleScreen() {
    var text by remember { mutableStateOf("012345678") }

    Div(
        attrs = { }
    ) {
        Div {
            Input(
                value = text,
                onChange = {
                    if (it.length <= 10) {
                        text = it
                    }
                },
            )
            +"10文字まで"
        }
        Div {
            +text
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
