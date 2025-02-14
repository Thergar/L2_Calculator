import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("java")
    id("application")

    id("org.springframework.boot") version "3.4.2"
    id("io.spring.dependency-management") version "1.1.7"
}

tasks.named<BootJar>("bootJar") {
    archiveFileName.set("L2_Calculator.jar")
}



group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    // Starter for Spring Boot.
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.4.2")

    // Driver for PostgresSQL.
    implementation ("org.postgresql:postgresql:42.7.5")

    // 
    implementation ("io.github.cdimascio:dotenv-java:3.1.0")

    // Dependencies for tests.
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.junit.jupiter:junit-jupiter-engine")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<JavaCompile> {
    options.compilerArgs.add("-Xlint:unchecked")
}

tasks.withType<JavaExec> {
    jvmArgs = listOf("-Xmx1024m", "-Xms512m")
}

springBoot {
    mainClass.set("Lineage2Calculator.Main")
}

