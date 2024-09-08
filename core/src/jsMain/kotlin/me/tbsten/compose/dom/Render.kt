package me.tbsten.compose.dom

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ControlledComposition
import androidx.compose.runtime.DefaultMonotonicFrameClock
import androidx.compose.runtime.Recomposer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.w3c.dom.HTMLElement

fun HTMLElement.renderComposable(
    content: @Composable () -> Unit,
) {
    GlobalSnapshotManager.ensureStarted()

    val recompositionContext = DefaultMonotonicFrameClock + Dispatchers.Main
    val recomposer = Recomposer(recompositionContext)

    val composition = ControlledComposition(
        applier = JsDomApplier(this),
        parent = recomposer,
    )

    composition.setContent(content)

    CoroutineScope(recompositionContext).launch(start = CoroutineStart.UNDISPATCHED) {
        recomposer.runRecomposeAndApplyChanges()
    }
}
