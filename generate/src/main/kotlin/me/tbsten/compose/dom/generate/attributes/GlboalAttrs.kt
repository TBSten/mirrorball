package me.tbsten.mirrorball.generate.attributes

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FunSpec
import me.tbsten.mirrorball.attributes.AttrsScope
import me.tbsten.mirrorball.generate.Attribute
import me.tbsten.mirrorball.generate.AttributesPackageName
import me.tbsten.mirrorball.generate.BooleanAttribute
import me.tbsten.mirrorball.generate.EnumAttribute
import me.tbsten.mirrorball.generate.NumberAttribute
import me.tbsten.mirrorball.generate.StringAttribute
import me.tbsten.mirrorball.generate.autoGenerateFileSpecBuilder
import me.tbsten.mirrorball.generate.definition.globalAttributes
import me.tbsten.mirrorball.generate.lowerCamelCase2UpperCamelCase
import java.io.File
import kotlin.reflect.KClass

suspend fun generateGlobalAttrsFile(generateDirectory: File) {
    val globalAttrsFile =
        File(generateDirectory, "attributes/GlobalAttrs.kt")
            .also { it.parentFile.mkdirs() }
    println("globalAttrsFile: $globalAttrsFile (exists:${globalAttrsFile.exists()})")
    val globalAttrsFileSpec =
        autoGenerateFileSpecBuilder(AttributesPackageName, "GlobalAttrs")
            .let { file ->
                globalAttributes.fold(file) { file, attr ->
                    when (attr) {
                        is StringAttribute ->
                            file.addFunction(attrFunSpec(attr, String::class).build())

                        is NumberAttribute -> {
                            file.addFunction(attrFunSpec(attr, Int::class).build())
                            file.addFunction(attrFunSpec(attr, Float::class).build())
                        }

                        is BooleanAttribute -> {
                            file.addFunction(attrFunSpec(attr, Boolean::class).build())
                        }

                        is EnumAttribute -> {
                            val enumName =
                                ClassName(
                                    AttributesPackageName,
                                    lowerCamelCase2UpperCamelCase(attr.kotlinName),
                                )
                            file.addFunction(
                                FunSpec
                                    // fun ${composableName}AttrsScope.${attr.kotlinName}(arg)
                                    .builder(attr.kotlinName)
                                    .receiver(AttrsScope::class)
                                    .addParameter(attr.kotlinName, enumName)
                                    // body
                                    .addStatement(
                                        """attr(%S, ${attr.kotlinName}.enumValue)""",
                                        attr.htmlName,
                                    ).build(),
                            )
                            file.addType(
                                attrEnumTypeSpec(attr, enumName),
                            )
                        }
                    }
                }
            }
    globalAttrsFile.bufferedWriter().use {
        it.write(globalAttrsFileSpec.build().toString())
    }
}

private fun <T : Any> attrFunSpec(
    attr: Attribute,
    type: KClass<T>,
) = FunSpec
    // fun AttrsScope.${attr.kotlinName}(arg)
    .builder(attr.kotlinName)
    .receiver(AttrsScope::class)
    .addParameter(attr.kotlinName, type)
    // body
    .addStatement("""attr(%S, ${attr.kotlinName})""", attr.htmlName)
