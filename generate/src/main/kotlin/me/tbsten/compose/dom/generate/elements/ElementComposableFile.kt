package me.tbsten.compose.dom.generate.elements

import androidx.compose.runtime.Composable
import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.LambdaTypeName
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.asClassName
import com.squareup.kotlinpoet.buildCodeBlock
import com.squareup.kotlinpoet.typeNameOf
import me.tbsten.compose.dom.HtmlTagRef
import me.tbsten.compose.dom.generate.ElementsPackageName
import me.tbsten.compose.dom.generate.LibraryPackageName
import me.tbsten.compose.dom.generate.autoGenerateFileSpecBuilder

fun elementComposableFile(
    composableName: String,
    htmlName: String,
) = autoGenerateFileSpecBuilder(ElementsPackageName, composableName)
    .addFunction(htmlTagComposableFunSpec(composableName, htmlName))

private fun htmlTagComposableFunSpec(
    composableName: String,
    htmlName: String,
) = FunSpec.builder(composableName)
    .addAnnotation(Composable::class)
    .addParameters(argumentsSpecs(composableName))
    .addStatement(
        "val attrsScope = %T(ref = ref).apply { attrs() }",
        ClassName(ElementsPackageName, "${composableName}AttrsScope"),
    )
    .addCode(
        buildCodeBlock {
            addStatement(
                "val tagContent :  @%T() (%T.() -> Unit) = {",
                Composable::class,
                ClassName("me.tbsten.compose.dom", "HtmlTagContentScope"),
            )
            addStatement("val scope = ${composableName}ContentScope(ref)")
            addStatement("scope.content()")
            addStatement("}")
        },
    )
    .addStatement(
        "%T(" +
            "localName = %S, " +
            "attrs = { applyScope(attrsScope) }, " +
            "ref = ref, " +
            "content = tagContent," +
            "dangerouslySetInnerHTML = dangerouslySetInnerHTML," +
            ")",
        ClassName(
            LibraryPackageName,
            "HtmlTag",
        ), // Composable関数を自動生成ファイルで参照できないためClassNameで指定している
        htmlName,
    )
    .build()

private fun argumentsSpecs(composableName: String) =
    listOf(
        ParameterSpec.builder(
            "attrs",
            LambdaTypeName.get(
                receiver = ClassName(ElementsPackageName, "${composableName}AttrsScope"),
                returnType = typeNameOf<Unit>(),
            ),
        )
            .defaultValue("{ }")
            .build(),
        ParameterSpec.builder(
            "ref",
            HtmlTagRef::class,
        )
            .defaultValue(
                CodeBlock.of(
                    "%T()",
                    ClassName(LibraryPackageName, "rememberDefaultHtmlTagRef"),
                ),
            )
            .build(),
        ParameterSpec.builder(
            "dangerouslySetInnerHTML",
            String::class.asClassName().copy(nullable = true),
        )
            .defaultValue(CodeBlock.of("null"))
            .build(),
        ParameterSpec.builder(
            "content",
            LambdaTypeName.get(
                receiver = ClassName(ElementsPackageName, "${composableName}ContentScope"),
                returnType = typeNameOf<Unit>(),
            ).copy(annotations = listOf(AnnotationSpec.builder(Composable::class).build())),
        )
            .defaultValue("{ }")
            .build(),
    )
