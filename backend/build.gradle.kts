plugins {
    `java-library`
    id("org.springframework.boot") version "3.2.2"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("com.github.node-gradle.node") version "3.3.0"
    id("com.google.cloud.tools.jib") version "3.2.1"
}

group = "ch.ergon.lernende"
version = "0.0.1-SNAPSHOT"

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

dependencies {
    implementation(project("db-model"))
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-jooq")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.flywaydb:flyway-core:10.8.1")
    implementation("org.flywaydb:flyway-mysql:10.8.1")
    implementation("com.mysql:mysql-connector-j:8.3.0")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.mockito:mockito-core:5.10.0")
}

tasks {
    test {
        useJUnitPlatform()
    }

    compileJava {
        dependsOn(":backend:db-model:generateJooq")
    }
}
