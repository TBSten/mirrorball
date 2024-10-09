package me.tbsten.mirrorballbow.server

import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider

class BowClientPageListProcessorProvider : SymbolProcessorProvider {
    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor =
        BowClientPageListProcessor(
            environment.codeGenerator,
            environment.logger,
            environment.options,
        )
}
