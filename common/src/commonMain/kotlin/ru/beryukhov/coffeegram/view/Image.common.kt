package ru.beryukhov.coffeegram.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.beryukhov.coffeegram.data.CoffeeType

//Default values in expect actual are currently not supported by the compose compiler. See also https://issuetracker.google.com/issues/196413692
@Composable
expect fun Image(coffeeType: CoffeeType, modifier: Modifier/* = Modifier*/)