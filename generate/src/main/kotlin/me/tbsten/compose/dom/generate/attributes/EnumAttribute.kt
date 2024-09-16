package me.tbsten.compose.dom.generate.attributes

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import me.tbsten.compose.dom.generate.EnumAttribute

fun attrEnumTypeSpec(
    attr: EnumAttribute,
    enumName: ClassName,
) =
    TypeSpec
        .enumBuilder(enumName)
        .primaryConstructor(
            FunSpec.constructorBuilder()
                .addParameter("enumValue", String::class)
                .build()
        )
        .addProperty(
            PropertySpec.builder("enumValue", String::class)
                .initializer("enumValue")
                .build()
        )
        .run {
            attr.values.fold(this) { enumBuilder, enumEntry ->
                enumBuilder
                    .addEnumConstant(
                        enumEntry.entryName,
                        TypeSpec.anonymousClassBuilder()
                            .addSuperclassConstructorParameter(
                                "%S",
                                enumEntry.entryValue
                            )
                            .build(),
                    )
            }
        }
        .build()
