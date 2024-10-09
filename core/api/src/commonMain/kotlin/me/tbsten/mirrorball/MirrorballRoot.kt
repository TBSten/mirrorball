package me.tbsten.mirrorball

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import me.tbsten.mirrorball.styleSheet.LocalMirrorballStyleSheet
import me.tbsten.mirrorball.styleSheet.MirrorballStyleSheet

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
