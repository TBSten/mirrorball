package me.tbsten.mirrorball.demo.client.slot.server

import io.ktor.server.application.Application
import io.ktor.server.engine.embeddedServer
import io.ktor.server.http.content.staticFiles
import io.ktor.server.netty.Netty
import io.ktor.server.routing.Routing
import io.ktor.server.routing.getAllRoutes
import io.ktor.server.routing.routing
import me.tbsten.mirrorball.bow.SerializableComposableLambda
import me.tbsten.mirrorball.bow.server.generated.BowBuildOutputDir
import me.tbsten.mirrorball.bow.slot.ClientSlot
import me.tbsten.mirrorball.demo.client.slot.shared.BasicSlot
import me.tbsten.mirrorball.demo.client.slot.shared.SlotWithArgs
import me.tbsten.mirrorball.demo.client.slot.shared.SlotWithComposableArg
import me.tbsten.mirrorball.elements.Body
import me.tbsten.mirrorball.elements.Div
import me.tbsten.mirrorball.elements.H1
import me.tbsten.mirrorball.elements.H2
import me.tbsten.mirrorball.elements.Head
import me.tbsten.mirrorball.elements.Html
import me.tbsten.mirrorball.elements.Script
import me.tbsten.mirrorball.elements.src
import me.tbsten.mirrorball.ktor.composable

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

                        H2 {
                            +"slot with @Composable args"
                        }
                        ClientSlot(
                            SlotWithComposableArg(
                                renderResult =
                                    SerializableComposableLambda {
                                        Div { +"this is render on server" }
                                    },
                            ),
                        )
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
