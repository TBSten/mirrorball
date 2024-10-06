package me.tbsten.compose.dom.demo.basic.server

import androidx.compose.runtime.Composable
import me.tbsten.compose.dom.elements.Body
import me.tbsten.compose.dom.elements.BodyContentScope
import me.tbsten.compose.dom.elements.Head
import me.tbsten.compose.dom.elements.HeadContentScope
import me.tbsten.compose.dom.elements.Html

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
