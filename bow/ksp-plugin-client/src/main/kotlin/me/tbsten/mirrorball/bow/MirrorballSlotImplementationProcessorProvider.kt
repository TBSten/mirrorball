package me.tbsten.mirrorball.bow

import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider

class MirrorballSlotImplementationProcessorProvider : SymbolProcessorProvider {
    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor = MirrorballSlotImplementationProcessor(environment.codeGenerator, environment.logger)
}
