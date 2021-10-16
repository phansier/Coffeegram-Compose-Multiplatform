package coffeegram

import androidx.compose.foundation.LocalScrollbarStyle
import androidx.compose.foundation.ScrollbarStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import ru.beryukhov.coffeegram.DefaultPreview

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "CoffeeGram",
        state = rememberWindowState(width = 800.dp, height = 600.dp)
    ) {
        MaterialTheme {
            CompositionLocalProvider(
                LocalScrollbarStyle provides ScrollbarStyle(
                    minimalHeight = 16.dp,
                    thickness = 8.dp,
                    shape = MaterialTheme.shapes.small,
                    hoverDurationMillis = 300,
                    unhoverColor = MaterialTheme.colors.onSurface.copy(alpha = 0.12f),
                    hoverColor = MaterialTheme.colors.onSurface.copy(alpha = 0.50f)
                )
            ) {
                DefaultPreview()
            }
        }
    }
}