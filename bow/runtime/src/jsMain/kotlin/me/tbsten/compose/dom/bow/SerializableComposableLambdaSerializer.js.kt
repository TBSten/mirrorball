package me.tbsten.compose.dom.bow

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import me.tbsten.compose.dom.elements.Div
import me.tbsten.compose.dom.renderComposable
import org.w3c.dom.Document

internal class SerializableComposableLambdaSerializer(private val document: Document) : KSerializer<SerializableComposableLambda> {
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

    override fun serialize(encoder: Encoder, value: SerializableComposableLambda) {
        val serializedContentElement = document.createElement("div")
            .apply {
                renderComposable { value() }
            }
        encoder.encodeString(serializedContentElement.toString())
    }
}
