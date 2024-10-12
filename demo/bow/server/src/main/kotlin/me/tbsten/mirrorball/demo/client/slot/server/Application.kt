package me.tbsten.mirrorball.demo.client.slot.server

import io.ktor.server.application.Application
import io.ktor.server.engine.embeddedServer
import io.ktor.server.http.content.staticFiles
import io.ktor.server.netty.Netty
import io.ktor.server.routing.Routing
import io.ktor.server.routing.getAllRoutes
import io.ktor.server.routing.routing
import me.tbsten.mirrorball.bow.buildInfo.generated.BowBuildOutputStaticDir
import me.tbsten.mirrorball.demo.client.slot.server.clienSlot.ClientSlotPage
import me.tbsten.mirrorball.demo.client.slot.server.top.TopPage
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
                TopPage(linkStyleSheet)
            }
        }
        composable("/client-slot") {
            content { linkStyleSheet ->
                ClientSlotPage(linkStyleSheet)
            }
        }
    }
}

fun Application.bowRouting(configuration: Routing.() -> Unit) =
    routing {
        staticFiles(
            "/",
            BowBuildOutputStaticDir,
        )

        configuration()
    }.also {
        // TODO handling static generation
        // https://youtrack.jetbrains.com/issue/KTOR-7510/Is-There-list-routing-path-in-ktor-server
        println("TODO: Handling Static Generation.")
        val routes = it.getAllRoutes()
        println("      routes=$routes")
    }
