package me.tbsten.compose.dom.bow

import androidx.compose.runtime.Composable
import kotlinx.serialization.json.Json

@Composable
expect fun defaultBowJson(): Json
