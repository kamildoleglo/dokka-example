package example


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

//inline fun <T, R : Comparable<R>> Array<out T>.sortBy(crossinline selector: (T) -> R?): Unit = TODO()
