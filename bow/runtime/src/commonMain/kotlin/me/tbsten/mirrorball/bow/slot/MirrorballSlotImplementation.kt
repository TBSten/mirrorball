package me.tbsten.mirrorball.bow.slot

import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION)
annotation class MirrorballSlotImplementation(
    val slot: KClass<out Slot>,
)
