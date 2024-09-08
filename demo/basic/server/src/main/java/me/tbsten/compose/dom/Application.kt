package me.tbsten.compose.dom

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    routing {
        page(TopPage)
    }
}


//suspend inline fun ApplicationCall.respondCss(builder: CssBuilder.() -> Unit) {
//    this.respondText(CssBuilder().apply(builder).toString(), ContentType.Text.CSS)
//}
