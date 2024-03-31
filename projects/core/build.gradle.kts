@file:Suppress("PropertyName")

plugins {
    `java-library`
    id("com.github.ben-manes.versions")
    id("com.github.johnrengelman.shadow")
}

base.archivesName.set("glitchify-core")

java.toolchain.languageVersion.set(JavaLanguageVersion.of(8))

dependencies {
    implementation("org.jetbrains:annotations:24.0.1")
    implementation("com.google.code.findbugs:jsr305:3.0.2")
    implementation("com.google.guava:guava:21.0")
    implementation("org.apache.logging.log4j:log4j-api:2.17.2")
    implementation("org.apache.logging.log4j:log4j-core:2.17.2")
}

tasks.shadowJar {
    dependencies {
        include(dependency("org.jetbrains:annotations"))
    }

    val relocatePackage = { p: String -> relocate(p, "glitchify.shadow.$p") }

    // org.jetbrains:annotations
    // relocatePackage("org.intellij.lang.annotations")
    // relocatePackage("org.jetbrains.annotations")

    exclude { fte ->
        // FileTreeElement returns null for file when it comes from a jar file (dependency).
        // This allows us to avoid excluding META-INF from our project's resources.
        // Might need to fix this in the future since we are relying on a bug...?
        // It's marked as non-nullable and the documentation says that it "Never returns null".
        @Suppress("UNNECESSARY_SAFE_CALL", "SENSELESS_COMPARISON")
        fte.file == null && fte.relativePath.startsWith("META-INF/")
    }

    exclude("module-info.class") // Java 9 feature
}

tasks.build {
    dependsOn(tasks.shadowJar)
}
