package me.tbsten.compose.dom.bow

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.contextual
import me.tbsten.compose.dom.LocalDocument
import me.tbsten.compose.dom.currentOrThrow
import me.tbsten.compose.dom.styleSheet.JvmMirrorballStyleSheet
import me.tbsten.compose.dom.styleSheet.LocalMirrorballStyleSheet

@Composable
actual fun defaultBowJson(): Json {
    val document = LocalDocument.currentOrThrow
    val styleSheet = LocalMirrorballStyleSheet.current as JvmMirrorballStyleSheet
    return remember {
        Json {
            serializersModule =
                SerializersModule {
                    contextual(SerializableComposableLambdaSerializer(document, styleSheet))
                }
        }
    }
}
