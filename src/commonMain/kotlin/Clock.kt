package example

/**
 * Documentation for expected class Clock
 * in common module
 */
expect open class Clock() {
    fun getTime(): String
    /**
     * Time in minis
     */
    protected fun getTimesInMillis(): String
    fun getYear(): String
}

