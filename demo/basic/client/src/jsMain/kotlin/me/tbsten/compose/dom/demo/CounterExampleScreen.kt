package me.tbsten.compose.dom.demo

import androidx.compose.runtime.*
import kotlinx.css.*
import me.tbsten.compose.dom.attributes.AttrsScope
import me.tbsten.compose.dom.attributes.className
import me.tbsten.compose.dom.attributes.style
import me.tbsten.compose.dom.element.event.onClick
import me.tbsten.compose.dom.elements.button.Button
import me.tbsten.compose.dom.elements.div.Div

@Composable
internal fun CounterExampleScreen() {
    var counter by remember { mutableIntStateOf(0) }

    Div(attrs = {
        rootStyle()
    }) {
        Div(attrs = { counterTextStyle() }) {
            +"$counter"
        }

        Div {
            Button(attrs = { className("button") }) {
                onClick { counter++ }
                +"count up"
            }

            Button(
                attrs = { className("button") },
            ) {
                onClick { counter-- }
                +"count down"
            }
        }
    }
}

private fun AttrsScope.rootStyle() = style {
    backgroundColor = Color("#FF0000")
    padding = Padding(10.px)
    textAlign = TextAlign.center
}

private fun AttrsScope.counterTextStyle() = style {
    fontSize = 20.px
}
