import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    id("java")
    id("org.jetbrains.kotlin.multiplatform") version "1.4-M2-eap-70"
    id("org.jetbrains.dokka") version "0.11.0-SNAPSHOT"
}

group = "org.jetbrains.dokka"
version = "1.0-SNAPSHOT"

repositories {
    maven("https://dl.bintray.com/kotlin/kotlin-dev")
    maven("https://dl.bintray.com/kotlin/kotlin-eap")
    mavenCentral()
    mavenLocal()
    jcenter()
}

dependencies {
    testImplementation(group ="junit", name = "junit", version = "4.12")
//    dokkaPlugins("org.jetbrains.dokka:mathjax-plugin:0.11.0-SNAPSHOT")
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
        val linuxX64Main by getting{
            dependsOn(commonMain)
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


        dokkaSourceSets {
            val commonMain by creating {}
            val jvmAndJsSecondCommonMain by creating{}
            val jsMain by creating {
                includes = listOf("src/jsMain/resources/doc.md")

                samples = listOf("src/jsMain/resources/Samples.kt")

                sourceLink {
                    path = "src/jsMain/kotlin"
                    url = "https://github.com/kamilok1965/dokka-example/tree/master/src/jsMain/kotlin"
                    lineSuffix = "#L"
                }
            }

            val jvmMain by creating {
                includes = listOf("src/jvmMain/resources/doc.md")

                samples = listOf("src/jsMain/resources/Samples.kt")

                sourceLink {
                    path = "src/jvmMain/kotlin"
                    url = "https://github.com/kamilok1965/dokka-example/tree/master/src/jvmMain/kotlin"
                    lineSuffix = "#L"
                }
            }

            val linuxX64Main by creating {
                sourceLink {
                    path = "src/linuxX64Main/kotlin"
                    url = "https://github.com/kamilok1965/dokka-example/tree/master/src/linuxX64Main/kotlin"
                    lineSuffix = "#L"
                }
                platform = "native"
            }
        }
    }
}
