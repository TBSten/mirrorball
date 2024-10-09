package me.tbsten.mirrorball

import org.w3c.dom.Element

val HtmlTagRef.currentElement: Element?
    get() = this.current as? Element
