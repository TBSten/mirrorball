package me.tbsten.compose.dom.demo.basic.server.top

import io.ktor.server.application.call
import io.ktor.server.routing.Routing
import io.ktor.server.routing.get
import me.tbsten.compose.dom.demo.basic.server.respondComposable
import me.tbsten.compose.dom.demo.basic.server.respondCss
import me.tbsten.compose.dom.styleSheet.JvmMirrorballStyleSheet

internal const val StyleRoute = "/__mirrorball_styles__.css"
fun Routing.topPage() {
    val styleSheet = JvmMirrorballStyleSheet()
    get("/") {
        call.respondComposable(styleSheet) {
            TopPage()
        }
    }
    get(StyleRoute) {
        call.respondCss { topPageCss() }
    }
}
