package me.tbsten.mirrorball.bow

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.contextual
import me.tbsten.mirrorball.LocalDocument
import me.tbsten.mirrorball.currentOrThrow
import me.tbsten.mirrorball.styleSheet.JvmMirrorballStyleSheet
import me.tbsten.mirrorball.styleSheet.LocalMirrorballStyleSheet

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
