package greeteer

actual class Executor{
    actual fun run() = "Virtual"

    /**
     * [timeout] without default value in jvmAndJsSecond
     */
    actual fun wait(timeout: Int) {
    }
}