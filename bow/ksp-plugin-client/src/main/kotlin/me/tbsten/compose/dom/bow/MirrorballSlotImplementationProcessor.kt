package me.tbsten.compose.dom.bow

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSFunctionDeclaration
import com.google.devtools.ksp.symbol.KSType

class MirrorballSlotImplementationProcessor(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger,
) : SymbolProcessor {
    /**
     * SlotとSlotContentのペア一覧のmapを生成する。
     */
    private var processed = false

    override fun process(resolver: Resolver): List<KSAnnotated> {
        if (processed) {
            return emptyList()
        } else {
            processed = true
        }

        val slotImplAnnotationName =
            requireNotNull(MirrorballSlotImplementation::class.qualifiedName)
        val slotImplFunctions =
            resolver.getSymbolsWithAnnotation(slotImplAnnotationName)
                .filterIsInstance<KSFunctionDeclaration>()

        val slotImplPairs =
            buildMap<KSType, KSFunctionDeclaration> {
                slotImplFunctions.forEach { impl ->
                    val slotImplAnnotationArguments =
                        impl.annotations.find {
                            it.annotationType.resolve().declaration.qualifiedName?.asString() == slotImplAnnotationName
                        }?.arguments
                    val slotClass =
                        slotImplAnnotationArguments
                            ?.find { it.name?.asString() == "slot" }
                            ?.value as KSType
                    put(slotClass, impl)
                }
            }

        val packageName = "me.tbsten.compose.dom.bow.generated"
        codeGenerator.createNewFile(
            Dependencies(
                false,
                *slotImplFunctions
                    .map { it.containingFile }
                    .filterNotNull()
                    .toList()
                    .toTypedArray(),
            ),
            packageName = packageName,
            fileName = "InjectClientSlots",
        ).use { output ->
            output.writer().use { writer ->
                writer.writeInjectClientSlots(
                    packageName = packageName,
                    slotImplPairs = slotImplPairs,
                )
            }
        }
        return listOf()
    }
}
