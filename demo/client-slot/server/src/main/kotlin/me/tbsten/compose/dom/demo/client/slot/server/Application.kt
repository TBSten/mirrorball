package me.tbsten.compose.dom.demo.client.slot.server

import io.ktor.server.application.Application
import io.ktor.server.engine.embeddedServer
import io.ktor.server.http.content.staticFiles
import io.ktor.server.netty.Netty
import io.ktor.server.routing.Routing
import io.ktor.server.routing.getAllRoutes
import io.ktor.server.routing.routing
import me.tbsten.compose.dom.bow.server.generated.BowBuildOutputDir
import me.tbsten.compose.dom.bow.slot.ClientSlot
import me.tbsten.compose.dom.demo.client.slot.shared.BasicSlot
import me.tbsten.compose.dom.demo.client.slot.shared.SlotWithArgs
import me.tbsten.compose.dom.elements.Body
import me.tbsten.compose.dom.elements.Div
import me.tbsten.compose.dom.elements.H1
import me.tbsten.compose.dom.elements.H2
import me.tbsten.compose.dom.elements.Head
import me.tbsten.compose.dom.elements.Html
import me.tbsten.compose.dom.elements.Script
import me.tbsten.compose.dom.elements.src
import me.tbsten.compose.dom.ktor.composable

fun main() {
    val host = System.getProperty("bow.host") ?: "0.0.0.0"
    val port = System.getProperty("bow.port")?.toIntOrNull() ?: 8080
    embeddedServer(
        Netty,
        host = host,
        port = port,
        module = Application::module,
    ).start(wait = true)
}

fun Application.module() {
    bowRouting {
        composable("/") {
            content { linkStyleSheet ->
                Html {
                    Head {
                        linkStyleSheet()
                        Script(attrs = { src("mirrorball_client_page.js") })
                    }
                    Body {
                        H1 {
                            +"`/` page"
                        }
                        Div {
                            +"this render on server"
                        }
                        H2 {
                            +"basic slot"
                        }
                        ClientSlot(BasicSlot)
                        H2 {
                            +"slot with args"
                        }
                        ClientSlot(SlotWithArgs(str = "test-1", int = 12345))
                    }
                }
            }
        }
    }
}

fun Application.bowRouting(configuration: Routing.() -> Unit) =
    routing {
        staticFiles(
            "/",
            BowBuildOutputDir,
        )

        configuration()
    }.also {
        // TODO handling static generation
        // https://youtrack.jetbrains.com/issue/KTOR-7510/Is-There-list-routing-path-in-ktor-server
        println("TODO: Handling Static Generation.")
        val routes = it.getAllRoutes()
        println("      routes=$routes")
    }
