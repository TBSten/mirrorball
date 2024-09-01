package me.tbsten.compose.dom

class JVMPlatform: Platform {
    override val name: String = "JavaScript"
    private val document = kotlinx.browser.document
}

actual fun getPlatform(): Platform = JVMPlatform()