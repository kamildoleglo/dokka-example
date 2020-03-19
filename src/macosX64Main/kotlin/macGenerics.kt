package example

fun main () {
    println("Hi there ");
}


class Bar<Z>
class Foo<out T: Comparable<*>, R: List<Bar<*>>>

fun <T, R> Foo<Comparable<*>, *>.baz(a : T): T where T : List<*>, T: Comparable<*> = TODO()
fun <T, R> Foo<Comparable<*>, *>.baz(a : T): T where R: Bar<Comparable<*>>, T : R = TODO()
fun <T> Foo<Comparable<*>, *>.baz(a : List<T>): T = TODO()

fun <T, R> Foo<Comparable<*>, *>.baz(a: T): T where T : List<Comparable<Int>> = TODO()
fun <T, R> Foo<Comparable<*>, *>.baz(a: T): T where T : List<Comparable<Bar<*>>> = TODO()

