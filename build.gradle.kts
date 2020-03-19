import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    id("java")
    id("org.jetbrains.kotlin.multiplatform") version "1.3.60"
    id("org.jetbrains.dokka") version "0.11.0-SNAPSHOT"
}

group = "org.jetbrains.dokka"
version = "1.0-SNAPSHOT"


repositories {
    maven(url = "https://dl.bintray.com/kotlin/kotlin-dev/")
    jcenter()
    mavenCentral()
    mavenLocal()
}

dependencies {
    testCompile(group = "junit", name = "junit", version = "4.12")
//    dokkaPlugins("org.jetbrains.dokka:mathjax-plugin:0.11.0-SNAPSHOT")
//    dokkaPlugins("org.jetbrains.dokka:kotlin-as-java-plugin:0.11.0-SNAPSHOT")
//    dokkaPlugins(project(":mergeFunctions"))
    dokkaPlugins("org.jetbrains.dokka:dokka-base:0.11.0-SNAPSHOT")
}

kotlin {
    jvm()
    js()
    macosX64() {
        binaries {
            executable()
        }
    }

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

        val macosX64Main by getting {
            dependencies {
                implementation(kotlin("stdlib"))
            }
        }
    }
}

tasks {
    val dokkaOutputDir = "dokka"

    val clean = getByName("clean", Delete::class) {
        delete(rootProject.buildDir)
        delete(dokkaOutputDir)
    }

    val dokka by getting(DokkaTask::class) {
        dependsOn(clean)
        outputDirectory = dokkaOutputDir
        outputFormat = "html"

        multiplatform {
//            val js by creating {}
            val jvm by creating {}
//            val macosX64 by creating {}
//            val common by creating {}
        }
    }
}