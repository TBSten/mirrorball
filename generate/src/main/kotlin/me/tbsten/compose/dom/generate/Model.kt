package me.tbsten.compose.dom.generate


data class Element(
    val elementName: String,
    val kotlinName: String = lowerCamelCase2UpperCamelCase(elementName),
    val hasContent: Boolean = true,
    val parent: List<String>? = null,
    val initialAttrs: Map<String, String> = mapOf(),
    val attrs: List<Attribute> = listOf(),
)

fun elementOf(
    elementName: String,
    kotlinName: String = lowerCamelCase2UpperCamelCase(elementName),
    hasContent: Boolean = true,
    parent: List<String>? = null,
    elementAttrs: ElementAttrsBuilderScope.() -> Unit,
): Element {
    val scope = ElementAttrsBuilderScope().apply(elementAttrs)
    return Element(
        elementName = elementName,
        kotlinName = kotlinName,
        hasContent = hasContent,
        parent = parent,
        initialAttrs = scope.initialAttrs,
        attrs = scope.attrs,
    )
}

class ElementAttrsBuilderScope {
    val attrs = mutableListOf<Attribute>()
    val initialAttrs = mutableMapOf<String, String>()
    operator fun Attribute.unaryPlus() {
        attrs.add(this)
    }

    fun initialAttr(name: String, value: String) {
        initialAttrs[name] = value
    }
}

@DslMarker
annotation class ElementDefineDsl

sealed interface Attribute {
    val htmlName: String
    val kotlinName: String
}

data class StringAttribute(
    override val htmlName: String,
    override val kotlinName: String = kebabCase2UpperCamelCase(htmlName),
) : Attribute

@ElementDefineDsl
fun ElementAttrsBuilderScope.strAttr(
    htmlName: String,
    kotlinName: String = kebabCase2LowerCamelCase(htmlName),
) = StringAttribute(htmlName, kotlinName).also { +it }

data class NumberAttribute(
    override val htmlName: String,
    override val kotlinName: String = kebabCase2LowerCamelCase(htmlName),
) : Attribute

@ElementDefineDsl
fun ElementAttrsBuilderScope.numAttr(
    htmlName: String,
    kotlinName: String = kebabCase2LowerCamelCase(htmlName),
) = NumberAttribute(htmlName, kotlinName).also { +it }

data class BooleanAttribute(
    override val htmlName: String,
    override val kotlinName: String,
) : Attribute

@ElementDefineDsl
fun ElementAttrsBuilderScope.boolAttr(
    htmlName: String,
    kotlinName: String = kebabCase2LowerCamelCase(htmlName),
) = BooleanAttribute(htmlName, kotlinName).also { +it }

data class EnumAttribute(
    override val htmlName: String,
    override val kotlinName: String,
    val values: List<EnumAttributeEntry>,
) : Attribute

@ElementDefineDsl
fun ElementAttrsBuilderScope.enumAttr(
    htmlName: String,
    kotlinName: String = kebabCase2LowerCamelCase(htmlName),
    values: EnumAttrValuesScope.() -> Unit,
) = EnumAttribute(
    htmlName = htmlName,
    kotlinName = kotlinName,
    values = EnumAttrValuesScope().apply(values).values,
).also { +it }

class EnumAttrValuesScope {
    val values = mutableListOf<EnumAttributeEntry>()
    operator fun EnumAttributeEntry.unaryPlus() {
        values.add(this)
    }
}

data class EnumAttributeEntry(
    val entryName: String,
    val entryValue: String,
)

@ElementDefineDsl
fun EnumAttrValuesScope.entry(
    entryName: String,
    entryValue: String,
) = EnumAttributeEntry(entryName, entryValue).also { +it }

@ElementDefineDsl
fun EnumAttrValuesScope.entry(
    entryValue: String,
) = entry(
    kebabCase2UpperCamelCase(entryValue),
    entryValue,
)
