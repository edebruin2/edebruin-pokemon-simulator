plugins {
    id("java")
}

group = "edu.sandiego.comp305.sp24"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    implementation("com.googlecode.json-simple:json-simple:1.1.1")
    testImplementation("org.junit.jupiter:junit-jupiter")
    // Mockito dependencies
    testImplementation("org.mockito:mockito-core:4.8.0")         // Core Mockito library
    testImplementation("org.mockito:mockito-junit-jupiter:4.8.0") // Integration support for JUnit Jupiter
}

tasks.test {
    useJUnitPlatform()
}