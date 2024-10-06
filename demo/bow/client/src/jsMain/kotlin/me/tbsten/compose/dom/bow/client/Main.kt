package me.tbsten.compose.dom.bow.client

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.Serializable
import me.tbsten.compose.dom.bow.MirrorballSlotImplementation
import me.tbsten.compose.dom.bow.Slot
import me.tbsten.compose.dom.bow.SlotContent
import me.tbsten.compose.dom.element.event.onClick
import me.tbsten.compose.dom.elements.Button
import me.tbsten.compose.dom.elements.Div
import me.tbsten.compose.dom.renderComposable
import org.w3c.dom.HTMLElement


@OptIn(InternalSerializationApi::class, ExperimentalSerializationApi::class)
fun main() {
//    console.log("slot content table", _MirrorballSlotContentTable_Generated)
//    _MirrorballSlotContentTable_Generated.forEach {
//        val slotElement = document
//            .getElementById("__mirrorball_bow_slot_${it.slotKey}") as HTMLElement
//
//        val arg = run {
//            val argElement = document.getElementById("__mirrorball_bow_arg_${it.slotKey}")!!
//            val json = Json {
//                allowTrailingComma = true
//                ignoreUnknownKeys = true
//            }
//            json.decodeFromString(it.slotKClass.serializer(), argElement.innerHTML)
//        }
//
//        slotElement.renderComposable {
//            @Suppress("UnsafeCastFromDynamic")
//            it.slotContent.Content(arg.asDynamic())
//        }
//    }

    window.addEventListener("load", {
        console.log("demo:bow:client")
        (document.getElementById("root") as HTMLElement)
            .renderComposable {
                var count by remember { mutableStateOf(0) }
                Div {
                    +"$count"
                    Button {
                        onClick { count++ }
                        +"client button"
                    }
                }
            }
    })
}

@Serializable
data object HogeSlot : Slot

@MirrorballSlotImplementation
object HogeContent : SlotContent<HogeSlot> {
    @Composable
    override fun Content(arg: HogeSlot) {
        Div { +"ok" }
    }
}

@Serializable
data class FugaSlot(
    val fuga1: String,
    val fuga2: Int,
) : Slot

@MirrorballSlotImplementation
object FugaContent : SlotContent<FugaSlot> {
    @Composable
    override fun Content(arg: FugaSlot) {
        Div {
            Div { +arg.fuga1 }
            Div { +"${arg.fuga2}" }
        }
    }
}
