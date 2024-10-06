package me.tbsten.compose.dom.bow

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.ClassKind
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSClassDeclaration

class MirrorballSlotImplementationProcessor(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger,
) : SymbolProcessor {
    /**
     * SlotとSlotContentのペア一覧のmapを生成する。
     */
    private var processed = false
    override fun process(resolver: Resolver): List<KSAnnotated> {
        if (processed) return emptyList()
        else processed = true
        logger.info("MirrorballSlotImplementationProcessor: start")
        val slotImplementations =
            resolver.getSymbolsWithAnnotation(MirrorballSlotImplementation::class.qualifiedName!!)
                .toList()
        logger.info("annotated symbols (${slotImplementations.size}):")
        val slotContentTable = mutableMapOf<String, String>()
        slotImplementations.forEach { slotImpl ->
            if (!slotImpl.isObject()) mbError("@MirrorballSlotImplementation must be a object")
            slotImpl as KSClassDeclaration
            val slotImplName = slotImpl.qualifiedName?.asString()!!

            // MirrorballSlotImplementationはSlotContentを継承する必要がある
            val slotContent =
                slotImpl.superTypes
                    .filter { it.resolve().declaration.qualifiedName?.asString() == "me.tbsten.compose.dom.bow.SlotContent" }
                    .firstOrNull()
            if (slotContent == null) {
                mbError(
                    "@MirrorballSlotImplementation class must be a object that implements SlotContent"
                )
            }

            val slot = slotContent.resolve().arguments[0]
            val slotName = slot.type?.resolve()?.declaration?.qualifiedName?.asString()!!

            slotContentTable[slotName] = slotImplName
            logger.info("  find slot and slotContent pair: $slotName to $slotImplName")
        }

        // mapを生成する
        codeGenerator.createNewFile(
            Dependencies.ALL_FILES,
            packageName = "me.tbsten.compose.dom.bow.generated",
            fileName = "GeneratedSlotContentTable",
        ).use { output ->
            output.writer().use { writer ->
                writer.writeMirrorballSlotContentTableEntries(slotContentTable)
            }
        }
        return listOf()
    }
}

private fun KSAnnotated.isObject() =
    this is KSClassDeclaration && this.classKind == ClassKind.OBJECT

internal fun mbError(message: String): Nothing =
    error("[ERROR] 🪩 $message")
