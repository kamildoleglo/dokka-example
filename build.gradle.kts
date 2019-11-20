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
}

val dokkaPlugins by configurations.getting

dependencies {
    testCompile(group ="junit", name = "junit", version = "4.12")
    dokkaPlugins("org.jetbrains.dokka:mathjax-plugin:0.10.1-SNAPSHOT")
}

kotlin {
    jvm()
    js()

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
            val js by creating {}
            val jvm by creating {}
        }
    }
}
