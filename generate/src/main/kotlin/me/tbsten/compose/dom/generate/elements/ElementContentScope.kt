package me.tbsten.mirrorball.generate.elements

import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.TypeSpec
import me.tbsten.mirrorball.HtmlTagContentScope
import me.tbsten.mirrorball.HtmlTagRef
import me.tbsten.mirrorball.generate.ElementsPackageName
import me.tbsten.mirrorball.generate.autoGenerateFileSpecBuilder

fun elementContentScopeFile(composableName: String) =
    autoGenerateFileSpecBuilder(ElementsPackageName, "${composableName}ContentScope")
        .addType(elementContentScopeSpec(composableName))

private fun elementContentScopeSpec(composableName: String) =
    TypeSpec
        .classBuilder("${composableName}ContentScope")
        .primaryConstructor(
            FunSpec
                .constructorBuilder()
                .addParameter("ref", HtmlTagRef::class)
                .build(),
        ).superclass(HtmlTagContentScope::class)
        .addSuperclassConstructorParameter("ref")
        .build()
