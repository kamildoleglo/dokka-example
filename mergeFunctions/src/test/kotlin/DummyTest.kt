package multiplatform

import org.junit.Assert.assertEquals
import org.junit.Test
import testApi.testRunner.AbstractCoreTest

class BasicMultiplatformTest : AbstractCoreTest() {

//    @Test
//    fun dataTestExample() {
//        val testDataDir = getTestDataDir("multiplatform/basicMultiplatformTest").toAbsolutePath()
//
//        val configuration = dokkaConfiguration {
//            passes {
//                pass {
//                    sourceRoots = listOf("$testDataDir/jvmMain/")
//                }
//            }
//        }
//
//        testFromData(configuration) {
//            pagesTransformationStage = {
//                assertEquals(6, it.children.firstOrNull()?.children?.count() ?: 0)
//            }
//        }
//    }

    @Test
    fun inlineTestExample() {
        val configuration = dokkaConfiguration {
            passes {
                pass {
                    sourceRoots = listOf("src/main/kotlin/multiplatform/Test.kt")
                }
            }
        }

        testInline(
            """
            |/src/main/kotlin/multiplatform/Test.kt
            |package multiplatform
            |
            |object Test {
            |   fun test2(str: String): Unit {println(str)}
            |}
        """.trimMargin(),
            configuration
        ) {
            pagesGenerationStage = {
                println(it.dri)
                assertEquals(7, it.parentMap.size)
            }
        }
    }
}

//Update packaging structure, simplify dependencies handling in plugins
//
//Fixes #627
//This commit removes repackaging `dokka-core` with all its dependencies by creating a publication for those dependencies. Moreover it moves `kotlinx-markdown` dependency to `coreDependencies` as this library is only present in Kotlin Bintray repository