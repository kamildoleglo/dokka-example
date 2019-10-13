package example

import greeteer.Greeter
import kotlin.js.Date

/**
 * Documentation for actual class Clock in JS
 */
actual class Clock {
    actual fun getTime() = Date.now().toString()
    fun onlyJsFunction(): Int = 42
}

fun main() {
    Greeter().greet().also { println(it) }
}