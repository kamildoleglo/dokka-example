package greeteer

expect class Executor(){
    fun run(): String

    /**
     * [timeout] without default value in Common
     */
    fun wait(timeout: Int)

}