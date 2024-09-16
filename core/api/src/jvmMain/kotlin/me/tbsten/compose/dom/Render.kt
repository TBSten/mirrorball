package me.tbsten.compose.dom

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ControlledComposition
import androidx.compose.runtime.Recomposer
import kotlinx.coroutines.Dispatchers
import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.html.HTMLElement

fun Node.renderComposable(
    content: @Composable () -> Unit,
) {
    val recompositionContext = Dispatchers.Main
    val recomposer = Recomposer(recompositionContext)

    val composition = ControlledComposition(
        applier = JvmDomApplier(this),
        parent = recomposer,
    )

    composition.setContent {
        ProvideRoot(
            document = if (this is Document) this else this.ownerDocument,
            rootNode = this,
            content = content,
        )
    }

    // not support recomposition in jvm .
}
