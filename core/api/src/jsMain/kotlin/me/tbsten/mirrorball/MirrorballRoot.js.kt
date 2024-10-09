package me.tbsten.mirrorball

import androidx.compose.runtime.Composable
import me.tbsten.mirrorball.styleSheet.JsMirrorballStyleSheet
import me.tbsten.mirrorball.styleSheet.MirrorballStyleSheet

@Composable
actual fun PlatformMirrorballRoot(
    styleSheet: MirrorballStyleSheet,
    content: @Composable () -> Unit,
) {
    content()
    (styleSheet as JsMirrorballStyleSheet).CollectUpdate()
}
