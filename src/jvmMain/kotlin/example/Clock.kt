package example

import greeteer.Greeter

actual class Clock {
    actual fun getTime(): String = System.currentTimeMillis().toString()

    /**
     * Documentation for onlyJVMFunction on...
     * wait for it...
     * ...JVM!
     */
    fun onlyJVMFunction(): Double = 2.5
}

fun clockList() = listOf(Clock())

fun main() {
    Greeter().greet().also { println(it) }
}