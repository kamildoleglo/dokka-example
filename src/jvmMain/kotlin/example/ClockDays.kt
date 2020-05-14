package example

enum class ClockDays {
    FIRST, SECOND, THIRD, FOURTH, FIFTH
}

val x = ClassLoader.getSystemClassLoader()

/**
 * Some docs that link to [ClassLoader.clearAssertionStatus]
 */
fun test(x: ClassLoader) = x.clearAssertionStatus()

class X
