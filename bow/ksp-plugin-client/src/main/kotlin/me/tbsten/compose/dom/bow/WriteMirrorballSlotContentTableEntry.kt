package me.tbsten.compose.dom.bow

import java.io.Writer

fun Writer.writeMirrorballSlotContentTableEntries(
    slotContentTable: Map<String, String>,
) {
    write("package me.tbsten.compose.dom.bow.generated\n")
    write("\n")
    write("import me.tbsten.compose.dom.bow.Slot\n")
    write("import me.tbsten.compose.dom.bow.SlotContent\n")
    write("import kotlin.reflect.KClass\n")
    write("\n")
    write("data class MirrorballSlotContentTableEntry<S : Slot>(\n")
    write("    val slotKey: String,\n")
    write("    val slotKClass: KClass<S>,\n")
    write("    val slotContent: SlotContent<S>,\n")
    write(")\n")
    write("\n")
    write("val _MirrorballSlotContentTable_Generated = listOf<MirrorballSlotContentTableEntry<*>>(\n")
    slotContentTable.forEach { (slotName, slotImplName) ->
        write("    MirrorballSlotContentTableEntry(\n")
        write("        \"$slotName\",\n")
        write("        $slotName::class,\n")
        write("        $slotImplName,\n")
        write("    ),\n")
    }
    write(")\n")
    write("\n")
}