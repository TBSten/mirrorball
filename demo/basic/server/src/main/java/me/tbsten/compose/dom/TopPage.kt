package me.tbsten.compose.dom

import androidx.compose.runtime.Composable
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.css.*
import me.tbsten.compose.dom.attributes.style
import me.tbsten.compose.dom.elements.div.Div
import me.tbsten.compose.dom.elements.head.Head
import me.tbsten.compose.dom.elements.html.Html
import org.w3c.dom.Document
import java.io.StringWriter
import java.io.Writer
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
        Html(attrs = { attr("lang", "jp") }) {
            Head {
                HtmlTag(
                    "link",
                    attrs = {
                        attr("rel", "stylesheet")
                        attr("href", styleSheetRoute)
                    },
                )
            }
            HtmlTag("body") {
                BodyContent()
            }
        }
    }

    @Composable
    fun BodyContent()
}

fun Routing.page(page: Page) {
    get(page.route) {
        val doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument()
        doc.renderComposable {
            page.Content()
        }
        call.respondText(doc.toHtmlString(), ContentType.Text.Html)
    }
    get(page.styleSheetRoute) {
        call.respondCss {
            with(page) { css() }
        }
    }
}

fun Document.toHtmlString(): String {
    val transformerFactory = TransformerFactory.newInstance()
    val transformer = transformerFactory.newTransformer()

    val source = DOMSource(this)

    val writer = StringWriter()
    val result = StreamResult(writer)

    transformer.transform(source, result)

    return writer.toString()
}

suspend inline fun ApplicationCall.respondCss(builder: CssBuilder.() -> Unit) {
    this.respondText(CssBuilder().apply(builder).toString(), ContentType.Text.CSS)
}

object TopPage : Page {
    override val route: String = ""

    @Composable
    override fun BodyContent() {
        Div(attrs = { style { backgroundColor = Color("#FF0000") } }) {
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
