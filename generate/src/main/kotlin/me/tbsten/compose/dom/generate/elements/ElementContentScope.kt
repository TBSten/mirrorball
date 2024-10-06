package me.tbsten.compose.dom.generate.elements

import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.TypeSpec
import me.tbsten.compose.dom.HtmlTagContentScope
import me.tbsten.compose.dom.HtmlTagRef
import me.tbsten.compose.dom.generate.ElementsPackageName
import me.tbsten.compose.dom.generate.autoGenerateFileSpecBuilder

fun elementContentScopeFile(composableName: String) =
    autoGenerateFileSpecBuilder(ElementsPackageName, "${composableName}ContentScope")
        .addType(elementContentScopeSpec(composableName))

private fun elementContentScopeSpec(composableName: String) =
    TypeSpec
        .classBuilder("${composableName}ContentScope")
        .primaryConstructor(
            FunSpec.constructorBuilder()
                .addParameter("ref", HtmlTagRef::class)
                .build(),
        )
        .superclass(HtmlTagContentScope::class)
        .addSuperclassConstructorParameter("ref")
        .build()
