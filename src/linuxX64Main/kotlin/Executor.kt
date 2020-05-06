package greeteer

actual class Executor{
    actual fun run() = "Native"

    /**
     * [timeout] without default value in Linux
     */
    actual fun wait(timeout: Int) {
    }
}