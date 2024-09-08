package me.tbsten.compose.dom.attributes

import me.tbsten.compose.dom.HtmlTagRef

open class AttrsScope(
    val ref: HtmlTagRef,
) {
    @PublishedApi
    internal val attrsMap = mutableMapOf<String, String>()

    @PublishedApi
    internal val updaters = mutableListOf<(ref: HtmlTagRef) -> Unit>()
    fun attr(name: String, value: String) {
        attrsMap[name] = value
    }

    fun prop(updater: (ref: HtmlTagRef) -> Unit) {
        updaters.add(updater)
    }

    fun applyScope(attrsScope: AttrsScope) {
        attrsMap += attrsScope.attrsMap
        updaters += attrsScope.updaters
    }
}
