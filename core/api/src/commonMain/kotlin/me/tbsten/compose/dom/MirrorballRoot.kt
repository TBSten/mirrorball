package me.tbsten.compose.dom

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import me.tbsten.compose.dom.styleSheet.LocalMirrorballStyleSheet
import me.tbsten.compose.dom.styleSheet.MirrorballStyleSheet

@Composable
fun MirrorballRoot(
    styleSheet: MirrorballStyleSheet,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalMirrorballStyleSheet provides styleSheet,
    ) {
        PlatformMirrorballRoot(styleSheet) {
            content()
        }
    }
}

@Composable
expect fun PlatformMirrorballRoot(
    styleSheet: MirrorballStyleSheet,
    content: @Composable () -> Unit,
)
