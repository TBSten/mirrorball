package me.tbsten.compose.dom.demo.basic.server.top

import androidx.compose.runtime.Composable
import kotlinx.css.Color
import kotlinx.css.backgroundColor
import kotlinx.css.color
import me.tbsten.compose.dom.demo.basic.server.BaseLayout
import me.tbsten.compose.dom.elements.Button
import me.tbsten.compose.dom.elements.ButtonType
import me.tbsten.compose.dom.elements.Div
import me.tbsten.compose.dom.elements.Link
import me.tbsten.compose.dom.elements.href
import me.tbsten.compose.dom.elements.rel
import me.tbsten.compose.dom.elements.type
import me.tbsten.compose.dom.styleSheet.mirrorballStyles
import me.tbsten.compose.dom.styleSheet.style

@Composable
internal fun TopPage() {
    BaseLayout(
        headContent = {
            Link(
                attrs = {
                    rel("stylesheet")
                    href(StyleRoute)
                }
            )
        },
        bodyContent = {
            val styles = mirrorballStyles()

            Div(
                attrs = {
                    style(styles) {
                        backgroundColor = Color.blue
                        color = Color.white
                        hover {
                            backgroundColor = Color.yellow
                            color = Color.black
                        }
                    }
                },
            ) {
                Button(attrs = {
                    type(ButtonType.Reset)
                }) { +"test" }
                +"top page"
            }
        },
    )
}
