package me.tbsten.mirrorballbow.server

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import kotlinx.serialization.Serializable
import me.tbsten.mirrorball.bow.server.util.requireNotNull

class BowClientPageListProcessor(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger,
    private val options: Map<String, String>,
) : SymbolProcessor {
    /**
     * ClientPage gradle pluginが設定されているモジュールをBowClientModules.moduleNameでアクセスできるようにする。
     */
    private var processed = false

    override fun process(resolver: Resolver): List<KSAnnotated> {
        if (processed) return emptyList()
        processed = true

        val buildOutputDir =
            options["bowInternal.buildOutputDir"]
                .requireNotNull { "Not Configured `bowInternal.buildOutputDir`" }
        codeGenerator
            .createNewFile(
                Dependencies(false),
                packageName = "me.tbsten.mirrorball.bow.server.generated",
                fileName = "BowBuildOutputDir",
            ).use {
                it.writer().use { writer ->
                    writer.writeBuildOutputDir(buildOutputDir)
                }
            }
        return listOf()
    }
}

@Serializable
internal data class BowClientModule(
    val projectDir: String,
    val module: String,
    val staticDir: String,
)
