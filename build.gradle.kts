plugins {
    `java-library`
}

allprojects {
    repositories {
        mavenCentral()
    }

    pluginManager.withPlugin("java-library") {
        java {
            toolchain {
                languageVersion.set(JavaLanguageVersion.of(17))
            }
        }
    }
}
