package me.tbsten.compose.dom

import org.w3c.dom.Element

val HtmlTagRef.currentElement: Element?
    get() = this.current as? Element
