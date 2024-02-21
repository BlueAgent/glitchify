@file:Suppress("PropertyName", "UnstableApiUsage")

import net.fabricmc.loom.api.LoomGradleExtensionAPI
import net.fabricmc.loom.task.GenerateSourcesTask
import org.gradle.util.Path

val mod_id: String by project
val minecraft_version: String by project
val parchment_version: String by project
val quilt_mappings: String by project

plugins {
    id("architectury-plugin")
    id("dev.architectury.loom") apply false
}

architectury {
    minecraft = minecraft_version
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "architectury-plugin")
    apply(plugin = "dev.architectury.loom")

    configure<BasePluginExtension> {
        archivesName.set("${mod_id}-${minecraft_version}")
    }

    repositories {
        exclusiveContent {
            forRepository {
                maven {
                    name = "Parchment"
                    url = uri("https://maven.parchmentmc.org")
                }
            }
            filter {
                includeGroupByRegex("""^org\.parchmentmc(?:\..+$|$)""")
            }
        }
        exclusiveContent {
            forRepository {
                maven {
                    name = "Quilt"
                    url = uri("https://maven.quiltmc.org/repository/release")
                }
            }
            filter {
                includeGroupByRegex("""^org\.quiltmc(?:\..+$|$)""")
            }
        }
    }

    configure<LoomGradleExtensionAPI> {
        silentMojangMappingsLicense()
    }

    val loom = the<LoomGradleExtensionAPI>()
    dependencies {
        "minecraft"("com.mojang:minecraft:${minecraft_version}")
        "mappings"(loom.layered {
            this.mappings("org.quiltmc:quilt-mappings:${minecraft_version}+build.${quilt_mappings}:intermediary-v2")
            this.parchment("org.parchmentmc.data:parchment-${minecraft_version}:${parchment_version}@zip")
            this.officialMojangMappings { nameSyntheticMembers = false }
        })
    }

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
        options.release.set(17)
    }

    configure<JavaPluginExtension> {
        toolchain.languageVersion.set(JavaLanguageVersion.of(17))
        withSourcesJar()
    }

    configure<LoomGradleExtensionAPI> {
        afterEvaluate {
            val genSources = tasks.named<Task>("genSources")
            val genSourcesWithVineflower = tasks.named<GenerateSourcesTask>("genSourcesWithVineflower")
            genSources.configure {
                // println(genSources.toString() + " (Before): " + dependsOn.joinToString(", "))
                val dependenciesWithoutGenSources = dependsOn
                    .filter { dependencyTask ->
                        val taskName = when (dependencyTask) {
                            is TaskProvider<*> -> dependencyTask.name
                            is Task -> dependencyTask.name
                            else -> return@filter true
                        }
                        return@filter !taskName.startsWith("genSourcesWith")
                    }
                setDependsOn(dependenciesWithoutGenSources + sequenceOf(genSourcesWithVineflower))
                // println(genSources.toString() + " (After): " + dependsOn.joinToString(", "))
            }

            val parentPath = Path.path(project.path).parent!!
            val projectDependencies = when (project.name) {
                "quiltish", "forge" -> setOf("vanilla")
                "fabric", "quilt" -> setOf("vanilla", "quiltish")
                else -> setOf()
            }.map { project(parentPath.child(it).path!!) }

            genSourcesWithVineflower.configure {
                mustRunAfter(projectDependencies.map { it.tasks.named<GenerateSourcesTask>("genSourcesWithVineflower") })
            }
        }
    }
}
