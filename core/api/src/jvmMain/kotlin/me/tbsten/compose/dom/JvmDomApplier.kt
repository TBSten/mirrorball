package me.tbsten.compose.dom

import androidx.compose.runtime.AbstractApplier
import org.w3c.dom.Node

internal class JvmDomApplier(root: Node) : AbstractApplier<Node>(root) {
    override fun onClear() {
//        root.clear()
        repeat(root.childNodes.length) {
            root.removeChild(root.childNodes.item(0))
        }
    }

    override fun insertBottomUp(
        index: Int,
        instance: Node,
    ) {
        val length = current.childNodes.length
        if (index < length) {
            instance.childNodes
            current.insertBefore(instance, instance.childNodes.item(index))
        } else {
            current.appendChild(instance)
        }
    }

    override fun insertTopDown(
        index: Int,
        instance: Node,
    ) {
        // ignored. Building tree bottom-up
    }

    override fun move(
        from: Int,
        to: Int,
        count: Int,
    ) {
        if (from == to) {
            return // nothing to do
        }

        for (i in 0 until count) {
            // if "from" is after "to," the from index moves because we're inserting before it
            val fromIndex = if (from > to) from + i else from
            val toIndex = if (from > to) to + i else to + count - 2

            val child = current.removeChild(current.childNodes.item(fromIndex))
            current.insertBefore(child, current.childNodes.item(toIndex))
        }
    }

    override fun remove(
        index: Int,
        count: Int,
    ) {
        repeat(count) {
            current.removeChild(current.childNodes.item(index))
        }
    }
}
