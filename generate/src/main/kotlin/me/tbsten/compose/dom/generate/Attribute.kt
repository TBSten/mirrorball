package me.tbsten.compose.dom.generate

fun Attribute.fileContent(parentElement: Element?) = when (this) {
    is BooleanAttribute -> """
        fun ${parentElement?.kotlinName ?: ""}AttrsScope.${this.htmlName}(${this.htmlName}: Boolean) =
            attr("${this.htmlName}", ${this.htmlName})

    """.trimIndent()

    is NumberAttribute -> """
        fun ${parentElement?.kotlinName ?: ""}AttrsScope.${this.kotlinName}(${this.kotlinName}: Int) =
            attr("${this.htmlName}", ${this.kotlinName})

        fun ${parentElement?.kotlinName ?: ""}AttrsScope.${this.kotlinName}(${this.kotlinName}: Float) =
            attr("${this.htmlName}", ${this.kotlinName})

    """.trimIndent()

    is StringAttribute -> """
        fun ${parentElement?.kotlinName ?: ""}AttrsScope.${this.kotlinName}(${this.kotlinName}: String) =
            attr("${this.htmlName}", ${this.kotlinName})

    """.trimIndent()

    is EnumAttribute -> {
        val element = parentElement?.elementName ?: ""
        val enumName = lowerCamelCase2UpperCamelCase("$element${this.kotlinName}")
        val enumArgName = "$element${this.kotlinName}"
        """
            |fun ${parentElement?.kotlinName ?: ""}AttrsScope.${this.kotlinName}($enumArgName: $enumName) =
            |    attr("${this.htmlName}", $enumArgName.value)
            |
            |enum class $enumName(val value: String) {
            |${this.values.joinToString("\n") { "    ${it.entryName}(\"${it.entryValue}\")," }}
            |}
            |
        """.trimMargin()
    }
} + "\n"
