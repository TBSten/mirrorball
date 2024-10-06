package me.tbsten.compose.dom.styleSheet

import androidx.compose.runtime.compositionLocalOf
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.css.CssBuilder
import kotlin.jvm.JvmInline

val GlobalStyleSheetKey = MirrorballStyleSheet.Key("__mirrorball_global_style_sheet")

abstract class MirrorballStyleSheet(internal val key: Key = GlobalStyleSheetKey) {
    private val builders = mutableMapOf<Int, CssBuilder.() -> Unit>()
    protected val onUpdate = MutableSharedFlow<Unit>(replay = 1)

    internal operator fun plusAssign(builder: CssBuilder.() -> Unit) {
        plusAssign(listOf(builder))
    }

    internal operator fun plusAssign(builders: List<CssBuilder.() -> Unit>) {
        this.builders += builders.map { builderPair(it) }
        onUpdate.tryEmit(Unit)
    }

    internal operator fun plusAssign(other: MirrorballStyleSheet) {
        this.plusAssign(other.builders.values.toList())
    }

    private fun builderPair(builder: CssBuilder.() -> Unit): Pair<Int, CssBuilder.() -> Unit> =
        CssBuilder().apply(builder).hashCode() to builder

    override fun toString(): String =
        CssBuilder()
            .apply {
                builders.values.forEach { builder ->
                    builder()
                }
            }
            .toString()

    override fun hashCode(): Int = builders.hashCode()

    override fun equals(other: Any?): Boolean {
        if (other !is MirrorballStyleSheet) return false
        return other.hashCode() == other.hashCode()
    }

    @JvmInline
    value class Key(val value: String)
}

val LocalMirrorballStyleSheet =
    compositionLocalOf<MirrorballStyleSheet> {
        error("Can not get LocalMirrorballStyleSheet.current. You forgot surround by MirrorballStyleSheet ?")
    }
