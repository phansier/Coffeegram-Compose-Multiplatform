package ru.beryukhov.coffeegram.data

actual abstract class CoffeeType(
    actual val name: String,
    val iconPath: String = "images/coffee.png"
)

actual object Cappuccino : CoffeeType("Cappuccino", "images/cappucino.png")
actual object Latte : CoffeeType("Latte", "images/latte.png")
actual object Americano : CoffeeType("Americano", "images/coffee.png")
actual object CommonCoffee : CoffeeType("CommonCoffee")

