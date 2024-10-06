package me.tbsten.compose.dom.bow

import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION)
annotation class MirrorballSlotImplementation(val slot: KClass<out Slot>)
