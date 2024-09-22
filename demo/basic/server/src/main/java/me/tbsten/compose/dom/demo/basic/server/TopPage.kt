package me.tbsten.compose.dom.demo.basic.server

import androidx.compose.runtime.Composable
import io.ktor.http.ContentType
import io.ktor.server.application.ApplicationCall
import io.ktor.server.application.call
import io.ktor.server.response.respondOutputStream
import io.ktor.server.response.respondText
import io.ktor.server.routing.Routing
import io.ktor.server.routing.get
import kotlinx.css.Color
import kotlinx.css.CssBuilder
import kotlinx.css.Margin
import kotlinx.css.Padding
import kotlinx.css.backgroundColor
import kotlinx.css.color
import kotlinx.css.margin
import kotlinx.css.padding
import kotlinx.css.px
import me.tbsten.compose.dom.elements.Body
import me.tbsten.compose.dom.elements.Button
import me.tbsten.compose.dom.elements.ButtonType
import me.tbsten.compose.dom.elements.Div
import me.tbsten.compose.dom.elements.Head
import me.tbsten.compose.dom.elements.Html
import me.tbsten.compose.dom.elements.Link
import me.tbsten.compose.dom.elements.lang
import me.tbsten.compose.dom.elements.type
import me.tbsten.compose.dom.renderComposable
import me.tbsten.compose.dom.styleSheet.JvmMirrorballStyleSheet
import me.tbsten.compose.dom.styleSheet.mirrorballStyles
import me.tbsten.compose.dom.styleSheet.style
import org.w3c.dom.Document
import java.io.OutputStream
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult

interface Page {
    val route: String
    val styleSheetRoute
        get() = "$route/__mirrorball_css__"

    fun CssBuilder.css() {}

    @Composable
    fun Content() {
        Html(attrs = { lang("jp") }) {
            Head {
                Link(attrs = {
                    attr("rel", "stylesheet")
                    attr("href", styleSheetRoute)
                })
            }
            Body {
                BodyContent()
            }
        }
    }

    @Composable
    fun BodyContent()
}

fun Routing.page(page: Page) {
    val styleSheet = JvmMirrorballStyleSheet()
    get(page.route) {
        val doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument()
        styleSheet.hashCode()
        doc.renderComposable(styleSheet = styleSheet) {
            page.Content()
        }
        call.respondOutputStream(ContentType.Text.Html) {
            doc.pipeTo(this)
        }
    }
    get(page.styleSheetRoute) {
//        call.respondCss {
//            with(page) { css() }
//        }
        call.respondText(
            text = styleSheet.toString(),
            contentType = ContentType.Text.CSS,
        )
    }
}

fun Document.pipeTo(outputStream: OutputStream) {
    val transformer = TransformerFactory.newInstance().newTransformer()
    val source = DOMSource(this)

    val result = StreamResult(outputStream)

    transformer.transform(source, result)
}

suspend inline fun ApplicationCall.respondCss(crossinline builder: CssBuilder.() -> Unit) {
    this.respondText(CssBuilder().apply(builder).toString(), ContentType.Text.CSS)
}

object TopPage : Page {
    override val route: String = ""

    @Composable
    override fun BodyContent() {
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
//                style {
//                    backgroundColor = Color.red
//                }
            },
        ) {
            Button(attrs = {
                type(ButtonType.Reset)
            }) { +"test" }
            +"top page"
        }
    }

    override fun CssBuilder.css() {
        rule("html, body") {
            padding = Padding(0.px)
            margin = Margin(0.px)
            backgroundColor = Color("#00FF00")
        }
    }

}
