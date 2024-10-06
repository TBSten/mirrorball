package me.tbsten.compose.dom.bow.server

import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider

class BowClientPageListProcessorProvider :
    SymbolProcessorProvider {
    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor {
        return BowClientPageListProcessor(
            environment.codeGenerator,
            environment.logger,
            environment.options,
        )
    }
}
