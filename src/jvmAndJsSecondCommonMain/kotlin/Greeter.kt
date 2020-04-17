package greeteer

import example.Clock

class Greeter {
    /**
     * Some docs for the [greet] function
     */
    fun greet() = Clock(0).let{ "Hello there! THe time is ${it.getTime()}" }
}