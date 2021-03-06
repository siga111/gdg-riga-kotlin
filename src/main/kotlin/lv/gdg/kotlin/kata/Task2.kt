package lv.gdg.kotlin.kata

import lv.gdg.kotlin.kata.Coin.Penny


/**
 * There are four types of common coins in US currency:
 * quarters (25 cents)
 * dimes (10 cents)
 * nickels (5 cents)
 * pennies (1 cent)
 *
 * There are 6 ways to make change for 15 cents:
 * A dime and a nickel;
 * A dime and 5 pennies;
 * 3 nickels;
 * 2 nickels and 5 pennies;
 * A nickel and 10 pennies;
 * 15 pennies.
 *
 * How many ways are there to make change for a dollar
 * using these common coins? (1 dollar = 100 cents).
 */

sealed class Coin(val value: Int) {
    object Quarter : Coin(25)
    object Dime : Coin(10)
    object Nickel : Coin(5)
    object Penny : Coin(1)
}

fun Int.getPossibleCoinCombinations(): List<List<Coin>> {
    return (1..6).map { listOf<Coin>() }
}

fun Int.getCoins(coin: Coin)  = this / coin.value

fun Int.getChange(coin: Coin): Pair<Int, Int> {
    val count = this.getCoins(coin)
    val change = this % coin.value
    return (count to change)
}

fun Int.getPennies(): List<Penny> {
   return Penny * this
}

private infix operator fun <T:Coin> T.times(x: Int): List<T> {
    return (0..x).map {this}
}


