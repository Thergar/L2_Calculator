plugins {
    id("java")
    id("application")
}



group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit:junit-bom:5.9.1")
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.3.1")
    implementation("org.postgresql:postgresql:42.7.4")

    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

    //implementation("org.hibernate.orm:hibernate-core:6.5.2.Final")
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

application {
    mainClass = "Main"
}

