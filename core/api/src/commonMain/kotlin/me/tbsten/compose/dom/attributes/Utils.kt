package me.tbsten.compose.dom.attributes

fun AttrsScope.attr(
    name: String,
    value: Boolean,
) = attr(name, if (value) "true" else "false")

fun AttrsScope.attr(
    name: String,
    value: Int,
) = attr(name, value.toString())

fun AttrsScope.attr(
    name: String,
    value: Float,
) = attr(name, value.toString())
