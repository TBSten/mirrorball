package me.tbsten.mirrorball.demo

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.browser.document
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.css.Color
import kotlinx.css.Padding
import kotlinx.css.backgroundColor
import kotlinx.css.color
import kotlinx.css.padding
import kotlinx.css.px
import me.tbsten.mirrorball.element.event.onClick
import me.tbsten.mirrorball.elements.Button
import me.tbsten.mirrorball.elements.Div
import me.tbsten.mirrorball.elements.Hr
import me.tbsten.mirrorball.renderComposable
import me.tbsten.mirrorball.styleSheet.mirrorballStyles
import me.tbsten.mirrorball.styleSheet.style
import org.w3c.dom.HTMLElement

fun main() {
    val root = document.getElementById("root") as HTMLElement

    root.renderComposable {
//        CounterExampleScreen()
//        Div { +"---" }
//        TextFieldExampleScreen()
//        Div { +"---" }
//        Div { +"kotlin: ${KotlinVersion.CURRENT}" }
        val styles = mirrorballStyles()
        Div {
            +"test"
            Hr()

            var count by remember { mutableStateOf(0) }
            Div {
                +"$count"
            }
            Button(
                attrs = {
                    style(styles) {
                        backgroundColor =
                            when (count % 3) {
                                0 -> Color.blue
                                1 -> Color.red
                                2 -> Color.yellow
                                else -> Color.black
                            }
                        color = Color.white
                    }
                },
            ) {
                onClick {
                    println("onClick: $count")
                    count++
                }
                +"button\nclick me"
            }

            Hr()

            TestAnimSection()
        }
    }
}

@Composable
private fun TestAnimSection() {
    val alpha = remember { Animatable(0.25f) }
    val animPadding = remember { Animatable(0f) }
    LaunchedEffect(Unit) {
        joinAll(
            launch { alpha.animateTo(1f, tween(10_000)) },
            launch { animPadding.animateTo(10f, tween(10_000)) },
        )
    }

    val styles = mirrorballStyles()
    Div { +"${alpha.value}" }

    listOf(
        Color.red to "red",
        Color.blue to "blue",
        Color.green to "green",
        Color.yellow to "yellow",
    ).forEach { (color, title) ->
        Button(
            attrs = {
                style(styles) {
//                    padding = Padding(12.px * alpha.value * Random.nextFloat())
                    padding = Padding(animPadding.value.px)
                    backgroundColor = color.withAlpha(alpha.value.toDouble())
                }
            },
        ) {
            +title
        }
    }
}
