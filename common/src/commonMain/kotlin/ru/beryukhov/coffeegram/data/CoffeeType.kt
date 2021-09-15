package ru.beryukhov.coffeegram.data

expect abstract class CoffeeType {
    val name: String
}

fun coffeeTypeValues() = listOf(Latte, Cappuccino, Americano, CommonCoffee)//todo replace it by some enum
fun coffeeTypeValueOf(name: String): CoffeeType {
    return when (name){
        Latte.name -> Latte
        Cappuccino.name -> Cappuccino
        Americano.name -> Americano
        else -> CommonCoffee
    }
}

expect object Latte : CoffeeType
expect object Cappuccino : CoffeeType
expect object Americano : CoffeeType
expect object CommonCoffee : CoffeeType