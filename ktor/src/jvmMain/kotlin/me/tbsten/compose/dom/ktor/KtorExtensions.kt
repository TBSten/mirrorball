package me.tbsten.compose.dom.ktor

import androidx.compose.runtime.Composable
import io.ktor.http.ContentType
import io.ktor.server.application.ApplicationCall
import io.ktor.server.application.call
import io.ktor.server.response.respondOutputStream
import io.ktor.server.response.respondText
import io.ktor.server.routing.Routing
import io.ktor.server.routing.get
import io.ktor.util.pipeline.PipelineContext
import me.tbsten.compose.dom.elements.Link
import me.tbsten.compose.dom.elements.href
import me.tbsten.compose.dom.elements.rel
import me.tbsten.compose.dom.renderComposable
import me.tbsten.compose.dom.styleSheet.JvmMirrorballStyleSheet
import org.w3c.dom.Document
import java.io.OutputStream
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult

@Suppress("unused")
suspend fun ApplicationCall.respondComposable(
    styleSheet: JvmMirrorballStyleSheet,
    contentType: ContentType = ContentType.Text.Html,
    document: Document = DocumentBuilderFactory.newInstance().newDocumentBuilder()
        .newDocument(),
    content: @Composable () -> Unit,
) {
    respondOutputStream(contentType) {
        document
            .also { it.renderComposable(styleSheet) { content() } }
            .pipeTo(this)
    }
}

@Suppress("unused")
fun Document.pipeTo(outputStream: OutputStream) {
    val transformer = TransformerFactory.newInstance().newTransformer()
    val source = DOMSource(this)

    val result = StreamResult(outputStream)

    transformer.transform(source, result)
}

@Suppress("unused")
suspend fun ApplicationCall.respondStyleSheet(
    styleSheet: JvmMirrorballStyleSheet,
) {
    respondText(styleSheet.toString(), ContentType.Text.CSS)
}

fun Routing.composable(
    path: String,
    styleSheetFileName: String = "style.css",
    styleSheet: JvmMirrorballStyleSheet = JvmMirrorballStyleSheet(),
    content: suspend MirrorballKtorComposableContentScope.() -> Unit,
) {
    val styleSheetPath =
        if (path.endsWith("/")) "$path/$styleSheetFileName"
        else "$path/$styleSheetFileName"

    get(path) {
        val scope = MirrorballKtorComposableContentScope(this)
        scope.apply {
            content()
        }
        call.respondComposable(styleSheet) {
            val linkStyleSheet = @Composable {
                Link(attrs = {
                    rel("stylesheet")
                    href("./$styleSheetPath")
                })
            }
            scope._content(linkStyleSheet)
        }
    }
    get(styleSheetPath) {
        call.respondStyleSheet(styleSheet)
    }
}

class MirrorballKtorComposableContentScope(
    val context: PipelineContext<Unit, ApplicationCall>,
) {
    @Suppress("PropertyName")
    internal var _content: @Composable (linkStyleSheet: @Composable () -> Unit) -> Unit = {}

    fun content(
        content: @Composable (linkStyleSheet: @Composable () -> Unit) -> Unit
    ) {
        this._content = content
    }
}
