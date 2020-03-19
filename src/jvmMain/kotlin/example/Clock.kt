package example

import greeteer.Greeter

open class CertainlyNotClock {
    val x: String = ""
    fun String.tst() = ""
    fun getTime(): String = System.currentTimeMillis().toString()
    fun getTimesInMillis(): String = System.currentTimeMillis().toString()

    /**
     * Documentation for onlyJVMFunction on...
     * wait for it...
     * ...JVM!
     */
    fun onlyJVMFunction(): Double = 2.5

    /**
     * Custom equals function
     */
    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    @Deprecated("deprecated", level = DeprecationLevel.ERROR, replaceWith = ReplaceWith("nothing"))
    open fun getDayOfTheWeek(): String {
        TODO("not implemented")
    }

    fun getYear(): String {
        TODO("not implemented")
    }
}

actual typealias Clock = CertainlyNotClock

interface TestInterface

class TestClassImplementsInterface : TestInterface

fun clockList() = listOf(Clock())

fun main() {
    Greeter().greet().also { println(it) }
}