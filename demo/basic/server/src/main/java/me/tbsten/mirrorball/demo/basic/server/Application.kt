package me.tbsten.mirrorball.demo.basic.server

import io.ktor.server.application.Application
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.routing.routing
import me.tbsten.mirrorball.demo.basic.server.top.topPage

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
    routing {
        topPage()
    }
}
