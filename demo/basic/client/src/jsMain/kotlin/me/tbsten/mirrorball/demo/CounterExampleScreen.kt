package me.tbsten.mirrorball.demo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.css.Color
import kotlinx.css.Padding
import kotlinx.css.TextAlign
import kotlinx.css.backgroundColor
import kotlinx.css.fontSize
import kotlinx.css.padding
import kotlinx.css.px
import kotlinx.css.textAlign
import me.tbsten.mirrorball.attributes.AttrsScope
import me.tbsten.mirrorball.attributes.style
import me.tbsten.mirrorball.element.event.onClick
import me.tbsten.mirrorball.elements.Button
import me.tbsten.mirrorball.elements.Div

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
            Button(attrs = { /* TODO className("button") */ }) {
                onClick { counter++ }
                +"count up"
            }

            Button(
                attrs = { /* TODO className("button")*/ },
            ) {
                onClick { counter-- }
                +"count down"
            }
        }
    }
}

private fun AttrsScope.rootStyle() =
    style {
        backgroundColor = Color("#FF0000")
        padding = Padding(10.px)
        textAlign = TextAlign.center
    }

private fun AttrsScope.counterTextStyle() =
    style {
        fontSize = 20.px
    }
