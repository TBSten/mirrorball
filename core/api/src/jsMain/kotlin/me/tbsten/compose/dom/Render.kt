package me.tbsten.compose.dom

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ControlledComposition
import androidx.compose.runtime.DefaultMonotonicFrameClock
import androidx.compose.runtime.Recomposer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.tbsten.compose.dom.styleSheet.JsMirrorballStyleSheet
import org.w3c.dom.HTMLElement

fun HTMLElement.renderComposable(
    styleSheet: JsMirrorballStyleSheet = JsMirrorballStyleSheet(),
    content: @Composable () -> Unit,
) {
    GlobalSnapshotManager.ensureStarted()

    val recompositionContext = DefaultMonotonicFrameClock + Dispatchers.Main
    val recomposer = Recomposer(recompositionContext)
    val applier = JsDomApplier(this)

    val composition = ControlledComposition(
        applier = applier,
        parent = recomposer,
    )

    composition.setContent {
        MirrorballRoot(styleSheet = styleSheet) {
            content()
        }
    }

    CoroutineScope(recompositionContext).launch(start = CoroutineStart.UNDISPATCHED) {
        recomposer.runRecomposeAndApplyChanges()
    }
}
