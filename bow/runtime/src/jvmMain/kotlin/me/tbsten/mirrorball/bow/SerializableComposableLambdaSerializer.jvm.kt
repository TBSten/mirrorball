package me.tbsten.mirrorball.bow

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import me.tbsten.mirrorball.elements.Div
import me.tbsten.mirrorball.renderComposable
import me.tbsten.mirrorball.styleSheet.JvmMirrorballStyleSheet
import org.w3c.dom.Document
import org.w3c.dom.Element
import java.io.StringWriter
import javax.xml.transform.OutputKeys
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult

internal class SerializableComposableLambdaSerializer(
    private val document: Document,
    private val styleSheet: JvmMirrorballStyleSheet,
) : KSerializer<SerializableComposableLambda> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor(
            "SerializableLambda",
            PrimitiveKind.STRING,
        )

    override fun deserialize(decoder: Decoder): SerializableComposableLambda {
        val html = decoder.decodeString()
        return SerializableComposableLambda {
            Div(
                dangerouslySetInnerHTML = html,
            )
        }
    }

    override fun serialize(
        encoder: Encoder,
        value: SerializableComposableLambda,
    ) {
        val element = document.createElement("div")
        element.renderComposable(
            styleSheet = styleSheet,
            content = value.content,
        )
        encoder.encodeString(element.toHtmlString())
    }
}

private fun Element.toHtmlString(): String {
    val transformer =
        TransformerFactory
            .newInstance()
            .newTransformer()
            .apply {
                setOutputProperty(OutputKeys.METHOD, "html")
            }

    val writer = StringWriter()
    val result = StreamResult(writer)
    val source = DOMSource(this)

    transformer.transform(source, result)
    return writer.toString()
}
