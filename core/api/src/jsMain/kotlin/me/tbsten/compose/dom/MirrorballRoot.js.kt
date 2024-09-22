package me.tbsten.compose.dom

import androidx.compose.runtime.Composable
import me.tbsten.compose.dom.styleSheet.JsMirrorballStyleSheet
import me.tbsten.compose.dom.styleSheet.MirrorballStyleSheet

@Composable
actual fun PlatformMirrorballRoot(
    styleSheet: MirrorballStyleSheet,
    content: @Composable () -> Unit,
) {
    content()
    (styleSheet as JsMirrorballStyleSheet).CollectUpdate()
}
