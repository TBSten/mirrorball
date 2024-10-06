package me.tbsten.compose.dom.styleSheet

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import kotlinx.css.CssBuilder
import me.tbsten.compose.dom.attributes.AttrsScope

@Composable
fun mirrorballStyles(): StyleRegister {
    val styleSheet = LocalMirrorballStyleSheet.current
    return remember { StyleRegister(styleSheet) }
}

class StyleRegister(
    internal val styleSheet: MirrorballStyleSheet,
)

fun AttrsScope.style(
    styles: StyleRegister,
    builder: CssBuilder.() -> Unit,
) {
    val appliedBuilder =
        CssBuilder().apply {
            builder()
        }
    val className = "mirrorball-${appliedBuilder.hashCode()}"

    // TODO 毎回追加しないように制御する
    styles.styleSheet += {
        rule(".$className") {
            append(appliedBuilder)
        }
    }
    attr("class", className)
}
