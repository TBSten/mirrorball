package me.tbsten.mirrorball.attributes

import kotlinx.css.CssBuilder

fun AttrsScope.style(block: CssBuilder.() -> Unit) {
    attr("style", CssBuilder().apply(block).toString())
}

fun AttrsScope.hidden(hidden: Hidden) {
    attr("hidden", hidden.value)
}

// FIXME: enum名と同じentryを定義できないため、ワークアラウンドとして別途定義している。
enum class Hidden {
    Hidden {
        override val value = "hidden"
    },
    UntilFound {
        override val value = "until-found"
    },
    ;

    abstract val value: String
}
