import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("java")
    id("application")

    id("org.springframework.boot") version "3.4.5"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    // Starter for Spring Boot.
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")

    // Driver for PostgresSQL.
    implementation ("org.postgresql:postgresql:42.7.5")

    // Dependency for dotenv.
    implementation ("io.github.cdimascio:dotenv-java:3.1.0")

    // Dependencies for tests.
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.testcontainers:postgresql:1.20.5")
    testImplementation("org.testcontainers:testcontainers:1.20.5")
    testImplementation("org.testcontainers:junit-jupiter:1.20.5")

    //Mockito dependencies.
    testImplementation("org.mockito:mockito-core:5.15.2")
    testImplementation("org.mockito:mockito-junit-jupiter:5.2.0")
}

application {
    mainClass.set("Lineage2Calculator.Main")
}

tasks.withType<JavaCompile> {
    options.compilerArgs.add("-Xlint:unchecked")
}

tasks.test {
    useJUnitPlatform()
}
