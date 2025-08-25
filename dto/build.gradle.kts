plugins {
    id("java-library")
}

group = "pl.l2calculator"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    api("com.fasterxml.jackson.core:jackson-annotations:2.17.1")

    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
}
