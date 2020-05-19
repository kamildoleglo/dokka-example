package example

import greeteer.Executor
import greeteer.Greeter
import greeteer.Platform
import kotlin.js.Date

/**
 * Documentation for actual class Clock in JS
 *
 * @sample samples.Samples.js
 * @constructor Set both the name for clock and current time but in JS
 * @see example.House Nice to look at this class but from JS
 */
actual open class Clock actual constructor(val int: Int, val string: String) {

    actual constructor(string: String) : this(0, string)

    actual constructor(int: Int) : this(int, "JS Clock")

    actual fun getTime() = Date.now().toString()
    fun onlyJsFunction(): Int = 42
    actual fun getTimesInMillis(): String = Date.now().toString()

    actual fun getYear(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * JS implementation for extension function
     *
     * @receiver JS receiver is time given in seconds
     */
    actual fun Int.extension(): String = "JS"

    /**
     * JS implementation for threeParams function
     *
     * @param a JS simple int
     * @param b JS another simple int
     * @param c JS last of these simple ints
     */
    actual fun threeParams(a: Int, b: Int, c: Int) = a + b + c

    actual fun <T> Int.foo(bar: T?): Unit = println("JS")
}

fun main() {
    Greeter().greet().also { println(it) }
    println("Kotlin for ${Platform().getPlatform()}/${Executor().run()}")
}
open class Bar<Z>
class ReBarBar : Bar<StringBuilder>()
class Foo<out T : Comparable<*>, R : List<Bar<*>>>
fun <T> Foo<Comparable<*>, T>.baz(a: T): T where T : List<ReBarBar>, T : Comparable<*> = kotlin.TODO()
fun <T, R> Foo<Comparable<*>, *>.baz(a: T): T where R : Bar<Comparable<*>>, T : R = kotlin.TODO()
fun <T> Foo<Comparable<*>, *>.baz(a: T): T where T : List<Comparable<Int>> = kotlin.TODO()
fun <T> Foo<Comparable<*>, *>.baz(a: T): T where T : List<Comparable<Bar<*>>> = kotlin.TODO()
fun <T : Comparable<Int>> Foo<T, *>.qux(): String = TODO()
fun <T : Comparable<Any?>> Foo<T, *>.qux(): String = TODO()
fun <T : Comparable<*>> Foo<T, *>.qux(): String = TODO()
fun <T, R : Foo<T, R>> Foo<*, *>.recursive2(): String = TODO()