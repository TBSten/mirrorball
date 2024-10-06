package me.tbsten.compose.dom.bow.server

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import me.tbsten.compose.dom.bow.server.util.requireNotNull

class BowClientPageListProcessor(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger,
    private val options: Map<String, String>,
) : SymbolProcessor {
    /**
     * ClientPage gradle pluginが設定されているモジュールをBowClientModules.moduleNameでアクセスできるようにする。
     */
    private var processed = false

    @OptIn(ExperimentalSerializationApi::class)
    override fun process(resolver: Resolver): List<KSAnnotated> {
        if (processed) return emptyList()
        processed = true
//        val clientPageModulesJson = File(
//            requireNotNull(options["bow.clientPageModules"]) { """"Can not find ksp arg `bow.clientPageModules`""" }
//        ).also { require(it.exists()) { "Not exists ${options["bow.clientPageModules"]} file" } }
//        val clientPageModules: Map<String, BowClientModule> =
//            Json.decodeFromStream(
//                clientPageModulesJson.inputStream()
//            )
//
//        codeGenerator.createNewFile(
//            Dependencies.ALL_FILES,
//            packageName = "me.tbsten.compose.dom.bow.server.generated",
//            fileName = "BowClientModules",
//        ).use { output ->
//            output.writer().use { writer ->
//                writer.writeBowClientModules(clientPageModules)
//            }
//        }
        val buildOutputDir = options.get("bowInternal.buildOutputDir")
            .requireNotNull { "Not Configured `bowInternal.buildOutputDir`" }
        codeGenerator.createNewFile(
            Dependencies.ALL_FILES,
            packageName = "me.tbsten.compose.dom.bow.server.generated",
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
