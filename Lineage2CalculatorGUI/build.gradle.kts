plugins {
    id("java")
    id("application")

    id("org.openjfx.javafxplugin") version "0.1.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

//    // Main dependencies for JavaFX
//    implementation("org.openjfx:javafx-controls:21.0.6")
//    implementation("org.openjfx:javafx-fxml:21.0.6")
    // ControlsFX library for additional UI controls.
    implementation("org.controlsfx:controlsfx:11.2.2")
}

javafx {
    version = "21.0.6"
    modules = listOf("javafx.controls", "javafx.fxml")
}

java {
    toolchain { languageVersion.set(JavaLanguageVersion.of(21)) }
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
