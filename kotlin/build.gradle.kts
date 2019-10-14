import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

plugins {
    kotlin("jvm") version "1.3.50"
    id("com.adarshr.test-logger") version "2.0.0"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("com.natpryce:hamkrest:1.7.0.0")
    testImplementation("junit:junit:4.12")
}

sourceSets["main"].withConvention(KotlinSourceSet::class) {
    kotlin.srcDir("src")
}
sourceSets["test"].withConvention(KotlinSourceSet::class) {
    kotlin.srcDir("test")
}
