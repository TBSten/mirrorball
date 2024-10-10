package me.tbsten.mirrorball

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ControlledComposition
import androidx.compose.runtime.Recomposer
import kotlinx.coroutines.Dispatchers
import me.tbsten.mirrorball.styleSheet.JvmMirrorballStyleSheet
import org.w3c.dom.Document
import org.w3c.dom.Node

fun Node.renderComposable(
    styleSheet: JvmMirrorballStyleSheet,
    content: @Composable () -> Unit,
) {
    val recompositionContext = Dispatchers.Main
    val recomposer = Recomposer(recompositionContext)

    val composition =
        ControlledComposition(
            applier = JvmDomApplier(this),
            parent = recomposer,
        )

    composition.setContent {
        MirrorballRoot(styleSheet = styleSheet) {
            ProvideRoot(
                document = if (this is Document) this else this.ownerDocument,
                rootNode = this,
                content = content,
            )
        }
    }

    // not support recomposition in jvm .
}
