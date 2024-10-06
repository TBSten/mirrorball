package me.tbsten.compose.dom.demo.bow.server


//import me.tbsten.compose.dom.bow.generated._MirrorballSlotContentTable_Generated
import androidx.compose.runtime.Composable
import io.ktor.server.application.Application
import io.ktor.server.engine.embeddedServer
import io.ktor.server.http.content.staticFiles
import io.ktor.server.netty.Netty
import io.ktor.server.routing.Routing
import io.ktor.server.routing.getAllRoutes
import io.ktor.server.routing.routing
import me.tbsten.compose.dom.attributes.id
import me.tbsten.compose.dom.bow.MirrorballSlotImplementation
import me.tbsten.compose.dom.bow.Slot
import me.tbsten.compose.dom.bow.SlotContent
import me.tbsten.compose.dom.bow.server.generated.BowBuildOutputDir
import me.tbsten.compose.dom.elements.Body
import me.tbsten.compose.dom.elements.Div
import me.tbsten.compose.dom.elements.Head
import me.tbsten.compose.dom.elements.Hr
import me.tbsten.compose.dom.elements.Html
import me.tbsten.compose.dom.elements.Script
import me.tbsten.compose.dom.elements.lang
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
                TopContent(
                    linkStyleSheet = linkStyleSheet,
                )
            }
        }
        composable("/top") {
            content { linkStyleSheet ->
                TopContent(
                    linkStyleSheet = linkStyleSheet,
                )
            }
        }
    }
}

@Composable
fun TopContent(linkStyleSheet: @Composable () -> Unit) {
    Html(attrs = { lang("ja") }) {
        Head {
            linkStyleSheet()
            Script(attrs = { src("./mirrorball_client_page.js") })
        }
        Body {
            Div { +"Hello" }
            Hr()
            Div(attrs = { id("root") })
        }
    }
}

// TODO move to framework code
fun Application.bowRouting(configuration: Routing.() -> Unit) =
    routing {
        staticFiles(
            "/",
            BowBuildOutputDir,
//        ) {
//            preCompressed(CompressedFileType.BROTLI, CompressedFileType.GZIP)
//        }
        )

        configuration()
    }.also {
        // TODO handling static generation
        // https://youtrack.jetbrains.com/issue/KTOR-7510/Is-There-list-routing-path-in-ktor-server
        println("TODO: Handling Static Generation.")
        val routes = it.getAllRoutes()
        println("      routes=$routes")
    }

data object HogeSlot : Slot

@MirrorballSlotImplementation
object HogeContent : SlotContent<HogeSlot> {
    @Composable
    override fun Content(arg: HogeSlot) {
        Div { +"ok" }
    }
}
