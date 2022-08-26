package ru.beryukhov.coffeegram.data

//Default values in expect actual are currently not supported by the compose compiler. See also https://issuetracker.google.com/issues/196413692
actual abstract class CoffeeType(
    actual val name: String,
    val iconPath: String/* = "images/coffee.png"*/
)

actual object Cappuccino : CoffeeType("Cappuccino", "images/cappucino.png")
actual object Latte : CoffeeType("Latte", "images/latte.png")
actual object Americano : CoffeeType("Americano", "images/coffee.png")
actual object CommonCoffee : CoffeeType("CommonCoffee", "images/coffee.png")

