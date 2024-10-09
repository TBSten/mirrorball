package me.tbsten.mirrorball.bow

import androidx.compose.runtime.Composable

class SerializableComposableLambda(
    val content: @Composable () -> Unit,
) {
    @Composable
    operator fun invoke() {
        content()
    }
}
