package ru.beryukhov.coffeegram.view

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.painter.Painter
import ru.beryukhov.coffeegram.data.CoffeeType

@Composable
actual fun Image(coffeeType: CoffeeType, modifier: Modifier) = Image(
//    painter = painterResource(coffeeType.iconPath),
    painter = object : Painter() {
        val color = when (coffeeType.iconPath) {
            "images/coffee.png" -> Color.Blue
            "images/cappucino.png" -> Color.Green
            "images/latte.png" -> Color.Red
            else -> Color.White
        }

        override val intrinsicSize: Size
            get() = Size(16f, 16f)

        override fun DrawScope.onDraw() {
            drawRect(color = color)
        }
    },
    contentDescription = "",
    modifier = modifier
)
