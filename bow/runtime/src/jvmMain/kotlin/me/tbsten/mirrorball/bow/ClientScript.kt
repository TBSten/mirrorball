package me.tbsten.mirrorball.bow

import androidx.compose.runtime.Composable
import me.tbsten.mirrorball.HtmlTagRef
import me.tbsten.mirrorball.elements.ScriptAttrsScope
import me.tbsten.mirrorball.elements.src
import me.tbsten.mirrorball.rememberDefaultHtmlTagRef

abstract class ClientScript(
    val pathInStaticDir: String,
)

@Composable
fun ClientScript.Script(
    src: (String) -> String = { it },
    attrs: ScriptAttrsScope.() -> Unit = { },
    ref: HtmlTagRef = rememberDefaultHtmlTagRef(),
    dangerouslySetInnerHTML: String? = null,
) {
    val scriptSrc = src(this.pathInStaticDir)
    me.tbsten.mirrorball.elements.Script(
        attrs = {
            this.src(scriptSrc)
            attrs()
        },
        ref = ref,
        dangerouslySetInnerHTML = dangerouslySetInnerHTML,
    )
}
