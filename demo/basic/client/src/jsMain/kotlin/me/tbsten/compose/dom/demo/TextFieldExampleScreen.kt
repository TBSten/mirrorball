package me.tbsten.compose.dom.demo

import androidx.compose.runtime.*
import me.tbsten.compose.dom.elements.div.Div

@Composable
fun TextFieldExampleScreen() {
    var text by remember { mutableStateOf("012345678") }

    Div {
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
