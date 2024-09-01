package me.tbsten.compose.dom

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform