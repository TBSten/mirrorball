package me.tbsten.mirrorball

import androidx.compose.runtime.AbstractApplier
import kotlinx.dom.clear
import org.w3c.dom.Node
import org.w3c.dom.get

class JsDomApplier(
    root: Node,
) : AbstractApplier<Node>(root) {
    override fun insertTopDown(
        index: Int,
        instance: Node,
    ) {
        // ignored. Building tree bottom-up
    }

    override fun insertBottomUp(
        index: Int,
        instance: Node,
    ) {
        val length = current.childNodes.length
        if (index < length) {
            current.insertBefore(instance, current.childNodes[index]!!)
        } else {
            current.appendChild(instance)
        }
    }

    override fun remove(
        index: Int,
        count: Int,
    ) {
        repeat(count) {
            current.removeChild(current.childNodes[index]!!)
        }
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

            val child = current.removeChild(current.childNodes[fromIndex]!!)
            current.insertBefore(child, current.childNodes[toIndex]!!)
        }
    }

    override fun onClear() {
        root.clear()
    }
}
