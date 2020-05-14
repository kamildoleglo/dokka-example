package example

import greeteer.Greeter
import kotlin.js.Date

/**
 * Documentation for actual class Clock in JS
 */
actual open class Clock {
    actual fun getTime() = Date.now().toString()
    fun onlyJsFunction(): Int = 42
    actual open fun getTimesInMillis(): String = Date.now().toString()

    actual fun getYear(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual val x: String
        get() = TODO("Not yet implemented")

    /**
     * Time in minis
     */
    actual fun String.tst(): String {
        TODO("Not yet implemented")
    }
}

fun main() {
    Greeter().greet().also { println(it) }
}

interface Interfac

actual typealias ClockInterface = Interfac
actual enum class ClockEnum : Interfac
actual object ClockObject

/**
 * JS documentation
 */
actual fun spanishInquisition() {}

actual annotation class A
class Baz