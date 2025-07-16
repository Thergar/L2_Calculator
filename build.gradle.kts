import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("java")
    id("application")

    id("org.springframework.boot") version "3.4.2"
    id("io.spring.dependency-management") version "1.1.7"
    id("org.openjfx.javafxplugin") version "0.0.10"
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

    // Main dependencies for JavaFX
    implementation("org.openjfx:javafx-controls:21.0.6")
    implementation("org.openjfx:javafx-graphics:21.0.6")
    implementation("org.openjfx:javafx-fxml:21.0.6")
    implementation("org.openjfx:javafx-base:21.0.6")

    // ControlsFX library for additional UI controls.
    implementation("org.controlsfx:controlsfx:11.2.2")


    // Starter for Spring Boot.
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.4.2")
    implementation("org.springframework.boot:spring-boot-starter-web:3.4.2")

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

javafx {
    version = "21.0.6"
    modules = listOf("javafx.controls", "javafx.fxml")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<JavaCompile> {
    options.compilerArgs.add("-Xlint:unchecked")
}

tasks.withType<JavaExec> {
    jvmArgs = listOf(
        "-Xmx1024m", "-Xms512m",
        "--module-path", "F:/JavaFX/lib",
        "--add-modules", "javafx.controls,javafx.fxml,javafx.graphics",
        "--add-exports=javafx.base/com.sun.javafx.event=ALL-UNNAMED"
    )
}


