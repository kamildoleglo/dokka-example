import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    id("java")
    id("org.jetbrains.kotlin.multiplatform") version "1.3.50"
    id("org.jetbrains.dokka") version "0.11.0-SNAPSHOT"
}

group = "org.jetbrains.dokka"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
    jcenter()
}

dependencies {
    testCompile(group ="junit", name = "junit", version = "4.12")
    dokkaPlugins("org.jetbrains.dokka:mathjax-plugin:0.11.0-SNAPSHOT")
}

kotlin {
    jvm()
    js()
    linuxX64()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
            }
        }

        val jvmAndJsSecondCommonMain by creating {
            dependsOn(commonMain)
        }

        val jvmMain by getting {
            dependsOn(jvmAndJsSecondCommonMain)
            dependencies {
                implementation(kotlin("stdlib"))
            }
        }

        val jsMain by getting {
            dependsOn(jvmAndJsSecondCommonMain)
            dependencies {
                implementation(kotlin("stdlib-js"))
            }
        }
    }
}

tasks {
    val dokkaOutputDir = "dokka"

    val clean = getByName("clean", Delete::class){
        delete(rootProject.buildDir)
        delete(dokkaOutputDir)
    }

    val dokka by getting(DokkaTask::class) {
        dependsOn(clean)

        outputDirectory = dokkaOutputDir
        outputFormat = "html"


        multiplatform {
            val js by creating {
                includes = listOf("src/jsMain/resources/doc.md")

                samples = listOf("src/jsMain/resources/Samples.kt")

                sourceLink {
                    path = "src/jsMain/kotlin"
                    url = "https://github.com/kamilok1965/dokka-example/tree/master/src/jsMain/kotlin"
                    lineSuffix = "#L"
                }
            }
            val jvm by creating {
                includes = listOf("src/jvmMain/resources/doc.md")

                samples = listOf("src/jsMain/resources/Samples.kt")

                sourceLink {
                    path = "src/jvmMain/kotlin"
                    url = "https://github.com/kamilok1965/dokka-example/tree/master/src/jvmMain/kotlin"
                    lineSuffix = "#L"
                }
            }
            val linuxX64 by creating {
                sourceLink {
                    path = "src/linuxX64Main/kotlin"
                    url = "https://github.com/kamilok1965/dokka-example/tree/master/src/linuxX64Main/kotlin"
                    lineSuffix = "#L"
                }
            }
        }
    }
}
