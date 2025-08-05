plugins {
    id("java")
    id("application")

    id("org.springframework.boot") version "3.4.5"
    id("io.spring.dependency-management") version "1.1.7"
    id("org.openjfx.javafxplugin") version "0.0.14"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    // Main dependencies for JavaFX
    implementation("org.openjfx:javafx-controls:21.0.6")
    implementation("org.openjfx:javafx-fxml:21.0.6")
    // ControlsFX library for additional UI controls.
    implementation("org.controlsfx:controlsfx:11.2.2")


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

javafx {
    version = "21.0.6"
    modules = listOf("javafx.controls", "javafx.fxml")
}

application {
    mainClass.set("Lineage2CalculatorGUI.MainFX")
}

tasks.withType<JavaExec>().configureEach {
    jvmArgs(
        "-Xmx1024m", "-Xms512m",
        "--add-exports=javafx.base/com.sun.javafx.event=ALL-UNNAMED"
    )
}

tasks.withType<JavaCompile> {
    options.compilerArgs.add("-Xlint:unchecked")
}

tasks.test {
    useJUnitPlatform()
}
