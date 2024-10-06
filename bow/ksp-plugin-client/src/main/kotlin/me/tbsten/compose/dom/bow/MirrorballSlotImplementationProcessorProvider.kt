package me.tbsten.compose.dom.bow

import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider

class MirrorballSlotImplementationProcessorProvider :
    SymbolProcessorProvider {
    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor {
        return MirrorballSlotImplementationProcessor(environment.codeGenerator, environment.logger)
    }
}
