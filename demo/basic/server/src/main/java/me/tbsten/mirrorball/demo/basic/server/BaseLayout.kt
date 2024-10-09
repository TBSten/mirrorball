package me.tbsten.mirrorball.demo.basic.server

import androidx.compose.runtime.Composable
import me.tbsten.mirrorball.elements.Body
import me.tbsten.mirrorball.elements.BodyContentScope
import me.tbsten.mirrorball.elements.Head
import me.tbsten.mirrorball.elements.HeadContentScope
import me.tbsten.mirrorball.elements.Html

@Composable
fun BaseLayout(
    headContent: @Composable HeadContentScope.() -> Unit = {},
    bodyContent: @Composable BodyContentScope.() -> Unit,
) {
    Html {
        Head {
            headContent()
        }
        Body {
            bodyContent()
        }
    }
}
