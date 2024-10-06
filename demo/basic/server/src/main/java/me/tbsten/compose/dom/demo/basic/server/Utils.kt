package me.tbsten.compose.dom.demo.basic.server

import androidx.compose.runtime.Composable
import io.ktor.http.ContentType
import io.ktor.server.application.ApplicationCall
import io.ktor.server.response.respondOutputStream
import io.ktor.server.response.respondText
import kotlinx.css.CssBuilder
import me.tbsten.compose.dom.renderComposable
import me.tbsten.compose.dom.styleSheet.JvmMirrorballStyleSheet
import org.w3c.dom.Document
import java.io.OutputStream
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult

suspend fun ApplicationCall.respondComposable(
    styleSheet: JvmMirrorballStyleSheet,
    content: @Composable () -> Unit,
) {
    val doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument()
    doc.renderComposable(styleSheet) { content() }

    respondOutputStream {
        doc.pipeTo(this)
    }
}

private fun Document.pipeTo(outputStream: OutputStream) {
    val transformer = TransformerFactory.newInstance().newTransformer()
    val source = DOMSource(this)

    val result = StreamResult(outputStream)

    transformer.transform(source, result)
}

suspend inline fun ApplicationCall.respondCss(crossinline builder: CssBuilder.() -> Unit) {
    this.respondText(CssBuilder().apply(builder).toString(), ContentType.Text.CSS)
}