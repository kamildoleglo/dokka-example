package example

import kotlin.reflect.KProperty

class Bar<Z>
class Foo<out T : Comparable<*>, R : List<Bar<*>>>

// same signature
//fun <T, R> Foo<Comparable<*>, *>.baz(a : T): T where T : List<*>, T: Comparable<*> = kotlin.TODO()
//fun <T, R> Foo<Comparable<*>, *>.baz(a : T): T where T: List<*> = kotlin.TODO()

// same signature
//inline fun <reified T, R> Foo<Comparable<*>, *>.baz(a: T): T where T : List<Comparable<Int>> = kotlin.TODO()
//inline fun <reified T, R> Foo<Comparable<*>, *>.baz(a: T): T where T : List<Comparable<Bar<*>>> = kotlin.TODO()
///**
// * Specifies that a corresponding member has the lowest priority in overload resolution.
// */
//@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY)
//@Retention(AnnotationRetention.BINARY)
//internal annotation class LowPriorityInOverloadResolution
//
//@Target(AnnotationTarget.TYPE)
//@Retention(AnnotationRetention.BINARY)
//internal annotation class Exact
//
//@JvmName("getVar")
//public inline operator fun <V, V1 : V> MutableMap<in String, out @Exact V>.getValue(thisRef: Any?, property: KProperty<*>): V1 = TODO()
//
//@Deprecated("Use getValue() with two type parameters instead", level = DeprecationLevel.ERROR)
//@JvmName("getVarContravariant")
//@LowPriorityInOverloadResolution
//public inline fun <V> MutableMap<in String, in V>.getValue(thisRef: Any?, property: KProperty<*>): V = TODO()