package me.tbsten.mirrorball

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocal
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import org.w3c.dom.Document
import org.w3c.dom.Node

val LocalDocument = compositionLocalOf<Document?> { null }

val CompositionLocal<Document?>.currentOrThrow
    @Composable
    get() = requireNotNull(current) { "Invalid Document: Document is null" }

val LocalRootNode = compositionLocalOf<Node?> { null }

val CompositionLocal<Node?>.currentOrThrow
    @Composable
    get() = requireNotNull(current) { "Invalid RootNode: RootNode is null" }

@Composable
fun ProvideRoot(
    document: Document,
    rootNode: Node,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalDocument provides document,
        LocalRootNode provides rootNode,
        content = content,
    )
}
