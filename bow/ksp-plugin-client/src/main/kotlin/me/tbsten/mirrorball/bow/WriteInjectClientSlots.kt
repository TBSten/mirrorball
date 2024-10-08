package me.tbsten.mirrorball.bow

import com.google.devtools.ksp.symbol.KSFunctionDeclaration
import com.google.devtools.ksp.symbol.KSType
import java.io.Writer

fun Writer.writeInjectClientSlots(
    packageName: String,
    slotImplPairs: Map<KSType, KSFunctionDeclaration>,
) {
    writeln("package $packageName")
    writeln()
    writeln("import me.tbsten.mirrorball.bow.slot.injectSlotImpl")
    writeln()
    writeln("fun injectClientSlots() {")
    slotImplPairs.forEach { (slotClass, implFun) ->
        val slotName = slotClass.declaration.qualifiedName?.asString()
        val implName = implFun.qualifiedName?.asString()

        writeln("    injectSlotImpl<$slotName>(slotClassName = \"$slotName\", impl = { $implName(it) })")
        writeln()
    }
    writeln("}")
}

private fun Writer.writeln() {
    write("\n")
}

private fun Writer.writeln(text: String) {
    write("$text\n")
}
