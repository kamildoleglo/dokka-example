plugins {
    kotlin("jvm")
}

repositories {
    jcenter()
    mavenLocal()
    mavenCentral()
}

dependencies {
    compileOnly("org.jetbrains.dokka:dokka-core:0.11.0-SNAPSHOT")
    implementation(kotlin("stdlib-jdk8"))

    testImplementation("org.jetbrains.dokka:dokka-test-api:0.11.0-SNAPSHOT")
    testImplementation("junit:junit:4.13")
}