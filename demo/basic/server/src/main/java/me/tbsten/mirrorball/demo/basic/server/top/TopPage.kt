package me.tbsten.mirrorball.demo.basic.server.top

import androidx.compose.runtime.Composable
import kotlinx.css.Color
import kotlinx.css.backgroundColor
import kotlinx.css.color
import me.tbsten.mirrorball.demo.basic.server.BaseLayout
import me.tbsten.mirrorball.elements.Button
import me.tbsten.mirrorball.elements.ButtonType
import me.tbsten.mirrorball.elements.Div
import me.tbsten.mirrorball.elements.Link
import me.tbsten.mirrorball.elements.href
import me.tbsten.mirrorball.elements.rel
import me.tbsten.mirrorball.elements.type
import me.tbsten.mirrorball.styleSheet.mirrorballStyles
import me.tbsten.mirrorball.styleSheet.style

@Composable
internal fun TopPage() {
    BaseLayout(
        headContent = {
            Link(
                attrs = {
                    rel("stylesheet")
                    href(StyleRoute)
                },
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
