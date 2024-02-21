pluginManagement {
    resolutionStrategy {
        eachPlugin {
            when (requested.id.toString()) {
                "com.github.ben-manes.versions" -> {
                    useModule("com.github.ben-manes:gradle-versions-plugin:0.51.0")
                }

                "com.github.johnrengelman.shadow" -> {
                    useModule("gradle.plugin.com.github.johnrengelman:shadow:8.0.0")
                }

                "net.kyori.blossom" -> {
                    useModule("net.kyori:blossom:2.1.0")
                }

                "architectury-plugin" -> {
                    // https://maven.architectury.dev/architectury-plugin/architectury-plugin.gradle.plugin/maven-metadata.xml
                    useModule("architectury-plugin:architectury-plugin.gradle.plugin:3.4-SNAPSHOT")
                }

                "dev.architectury.loom" -> {
                    // https://maven.architectury.dev/dev/architectury/loom/dev.architectury.loom.gradle.plugin/maven-metadata.xml
                    useModule("dev.architectury.loom:dev.architectury.loom.gradle.plugin:1.5-SNAPSHOT")
                }
            }
        }
    }
    repositories {
        maven {
            name = "Mojang"
            url = uri("https://libraries.minecraft.net")
            content {
                includeGroupByRegex("""^com\.mojang(?:\..+$|$)""")
                includeGroupByRegex("""^net\.minecraft(?:\..+$|$)""")
            }
        }
        maven {
            name = "Architectury"
            url = uri("https://maven.architectury.dev")
            content {
                includeGroupByRegex("""^architectury-plugin(?:\..+$|$)""")
                includeGroupByRegex("""^dev\.architectury(?:\..+$|$)""")
            }
        }
        maven {
            name = "Quilt"
            url = uri("https://maven.quiltmc.org/repository/release")
            content {
                includeGroupByRegex("""^org\.quiltmc(?:\..+$|$)""")
            }
        }
        maven {
            name = "MinecraftForge"
            url = uri("https://maven.minecraftforge.net")
            content {
                includeGroup("de.oceanlabs.mcp")
                includeGroup("net.minecraft")
                includeGroupByRegex("""^net\.minecraftforge(?:\..+$|$)""")
            }
        }
        maven {
            name = "Fabric"
            url = uri("https://maven.fabricmc.net")
            content {
                includeGroupByRegex("""^net\.fabricmc(?:\..+$|$)""")
            }
        }
        gradlePluginPortal {
            content {
                includeGroup("com.github.ben-manes")
                includeGroup("gradle.plugin.com.github.johnrengelman")
                includeGroup("gradle.plugin.org.jetbrains.gradle.plugin.idea-ext")
                includeGroup("net.kyori")
            }
        }
        mavenCentral()
    }
}

rootProject.name = "glitchify"

include("projects:minecraft:v1.20.1")
include("projects:minecraft:v1.20.1:vanilla")
include("projects:minecraft:v1.20.1:quiltish")
include("projects:minecraft:v1.20.1:quilt")
include("projects:minecraft:v1.20.1:forge")
include("projects:minecraft:v1.20.1:fabric")
