package me.tbsten.mirrorball.generate.elements

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.asTypeName
import com.squareup.kotlinpoet.buildCodeBlock
import me.tbsten.mirrorball.HtmlTagRef
import me.tbsten.mirrorball.attributes.AttrsScope
import me.tbsten.mirrorball.generate.Attribute
import me.tbsten.mirrorball.generate.AttributesPackageName
import me.tbsten.mirrorball.generate.BooleanAttribute
import me.tbsten.mirrorball.generate.ElementsPackageName
import me.tbsten.mirrorball.generate.EnumAttribute
import me.tbsten.mirrorball.generate.NumberAttribute
import me.tbsten.mirrorball.generate.StringAttribute
import me.tbsten.mirrorball.generate.autoGenerateFileSpecBuilder
import me.tbsten.mirrorball.generate.lowerCamelCase2UpperCamelCase
import kotlin.reflect.KClass

internal fun elementAttrsScopeFile(
    composableName: String,
    initialAttrs: Map<String, String>,
    attrs: List<Attribute>,
) = autoGenerateFileSpecBuilder(ElementsPackageName, "${composableName}AttrsScope")
    .addImport(AttributesPackageName, "attr") // Boolean等のattrがうまく参照できないためのワークアラウンド
    .addType(elementAttrsScopeClass(composableName, initialAttrs))
    .addAttrsExtensionFunctions(composableName, attrs)

private fun elementAttrsScopeClass(
    composableName: String,
    initialAttrs: Map<String, String>,
) = TypeSpec
    // class ${composableName}AttrsScope(ref: HtmlTagRef) : AttrsScope(ref = ref)
    .classBuilder("${composableName}AttrsScope")
    .primaryConstructor(
        FunSpec
            .constructorBuilder()
            .addParameter("ref", HtmlTagRef::class)
            .build(),
    ).superclass(AttrsScope::class)
    .addSuperclassConstructorParameter(CodeBlock.of("ref"))
    // init { attr("${initialAttrs[].key}", "${initialAttrs[].value}") }
    .initialAttrsInitializerBlock(initialAttrs)
    .build()

private fun TypeSpec.Builder.initialAttrsInitializerBlock(initialAttrs: Map<String, String>) =
    if (initialAttrs.isNotEmpty()) {
        addInitializerBlock(
            buildCodeBlock {
                initialAttrs.forEach { (name, value) ->
                    addStatement("attr(%S, %S)", name, value)
                }
            },
        )
    } else {
        this
    }

private fun FileSpec.Builder.addAttrsExtensionFunctions(
    composableName: String,
    attrs: List<Attribute>,
) = attrs.fold(this) { file, attr ->
    when (attr) {
        is StringAttribute ->
            file.addFunction(
                attrFunSpec(composableName, attr, String::class).build(),
            )

        is BooleanAttribute ->
            file.addFunction(
                attrFunSpec(composableName, attr, Boolean::class).build(),
            )

        is NumberAttribute -> {
            file.addFunction(
                attrFunSpec(composableName, attr, Int::class).build(),
            )
            file.addFunction(
                attrFunSpec(composableName, attr, Float::class).build(),
            )
        }

        is EnumAttribute -> {
            val enumName =
                ClassName(
                    ElementsPackageName,
                    "${composableName}${lowerCamelCase2UpperCamelCase(attr.kotlinName)}",
                )
            file.addFunction(
                FunSpec
                    // fun ${composableName}AttrsScope.${attr.kotlinName}(arg)
                    .builder(attr.kotlinName)
                    .receiver(ClassName(ElementsPackageName, "${composableName}AttrsScope"))
                    .addParameter(attr.kotlinName, enumName)
                    // body
                    .addStatement("""attr(%S, ${attr.kotlinName}.enumValue)""", attr.htmlName)
                    .build(),
            )
            file.addType(
                TypeSpec
                    .enumBuilder(enumName)
                    .primaryConstructor(
                        FunSpec
                            .constructorBuilder()
                            .addParameter("enumValue", String::class)
                            .build(),
                    ).addProperty(
                        PropertySpec
                            .builder("enumValue", String::class)
                            .initializer("enumValue")
                            .build(),
                    ).run {
                        attr.values.fold(this) { enumBuilder, enumEntry ->
                            enumBuilder
                                .addEnumConstant(
                                    enumEntry.entryName,
                                    TypeSpec
                                        .anonymousClassBuilder()
                                        .addSuperclassConstructorParameter(
                                            "%S",
                                            enumEntry.entryValue,
                                        ).build(),
                                )
                        }
                    }.build(),
            )
        }
    }
}

private inline fun <reified T : Any> attrFunSpec(
    composableName: String,
    attr: Attribute,
    type: KClass<T>,
) = attrFunSpec(
    composableName = composableName,
    attr = attr,
    className = type.asTypeName(),
)

private fun attrFunSpec(
    composableName: String,
    attr: Attribute,
    className: ClassName,
) = FunSpec
    // fun ${composableName}AttrsScope.${attr.kotlinName}(arg)
    .builder(attr.kotlinName)
    .receiver(ClassName(ElementsPackageName, "${composableName}AttrsScope"))
    .addParameter(attr.kotlinName, className)
    // body
    .addStatement("""attr(%S, ${attr.kotlinName})""", attr.htmlName)
