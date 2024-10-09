package me.tbsten.compose.dom.bow

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import kotlinx.browser.document
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.contextual

@Composable
actual fun defaultBowJson(): Json {
    return remember {
        Json {
            serializersModule =
                SerializersModule {
                    contextual(SerializableComposableLambdaSerializer(document))
                }
        }
    }
}
