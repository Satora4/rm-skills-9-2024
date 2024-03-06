import nu.studer.gradle.jooq.JooqEdition
import nu.studer.gradle.jooq.JooqGenerate
import org.jooq.meta.jaxb.Logging
import org.jooq.meta.jaxb.Property
import org.jooq.util.jaxb.tools.XMLAppendable

plugins {
    `java-library`
    id("nu.studer.jooq") version "8.2.3"
    id("org.flywaydb.flyway") version "10.8.1"
}

buildscript {
    dependencies {
        classpath(group = "com.mysql", name = "mysql-connector-j", version = "8.3.0")
        classpath("org.flywaydb:flyway-mysql:10.8.1")
    }
}

dependencies {
    api(group = "org.jooq", name = "jooq", version = "3.18.11")

    jooqGenerator(project(":backend:jooq-codegen-customization"))
    jooqGenerator(group = "com.mysql", name = "mysql-connector-j", version = "8.3.0")
}

val dbUsername by extra("user")
val dbPassword by extra("password")
val codegenDirectory = file("src/generated/java")
val jdbcUrl = "jdbc:mysql://localhost:3306/rm-skills-9"

flyway {
    // allows insertions via migration scripts
    mixed = true
    url = jdbcUrl
    user = dbUsername
    password = dbPassword
    cleanDisabled = false
}

tasks {
    withType<JooqGenerate> {
        dependsOn(named("flywayMigrate"))
    }
}

jooq {
    version.set("3.18.11")
    edition.set(JooqEdition.OSS)

    configurations {
        create("main") {
            jooqConfiguration {
                logging = Logging.WARN
                jdbc {
                    driver = "com.mysql.cj.jdbc.Driver"
                    url = jdbcUrl
                    user = dbUsername
                    password = dbPassword
                    properties.add(Property().withKey("PAGE_SIZE").withValue("2048"))
                }
                generator {
                    name = "org.jooq.codegen.JavaGenerator"
                    database {
                        name = "org.jooq.meta.mysql.MySQLDatabase"
                        excludes = "(?i)flyway_schema_history"
                        inputSchema = "rm-skills-9"
                    }
                    generate {
                        isDeprecated = false
                        isFluentSetters = false
                        isGeneratedAnnotation = false
                        isImmutablePojos = false
                        isJavaTimeTypes = true
                        isPojos = false
                        isRecords = true
                    }
                    target {
                        packageName = "ch.ergon.lernende.backend.db"
                        directory = "$codegenDirectory"
                    }
                    strategy {
                        name = "ch.ergon.lernende.backend.GeneratorStrategy"
                    }
                }
            }
        }
    }
}

inline operator fun <T : XMLAppendable> T.invoke(block: T.() -> Unit) {
    block()
}
