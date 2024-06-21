plugins {
    id("java")
}

group = "com.mohyla"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    implementation("com.squareup:javapoet:1.11.1")
    implementation(fileTree("libs"))
    compileOnly ("com.google.auto.service:auto-service:1.0")
    annotationProcessor ("com.google.auto.service:auto-service:1.0")
}

java {
    sourceCompatibility = JavaVersion.VERSION_18
    targetCompatibility = JavaVersion.VERSION_18
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}