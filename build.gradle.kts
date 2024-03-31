@file:Suppress("PropertyName")

val mod_id: String by project
val mod_version: String by project

allprojects {
    group = mod_id
    version = mod_version

    repositories {
        maven {
            name = "TerraformersMC"
            url = uri("https://maven.terraformersmc.com")
            content {
                includeGroupByRegex("""^dev\.emi(?:\..+$|$)""")
            }
        }
        maven {
            name = "Ladysnake Libs"
            url = uri("https://maven.ladysnake.org/releases")
            content {
                includeGroupByRegex("""^dev\.emi(?:\..+$|$)""")
                includeGroupByRegex("""^dev\.onyxstudios(?:\..+$|$)""")
            }
        }
        maven {
            name = "TheIllusiveC4"
            url = uri("https://maven.theillusivec4.top")
            content {
                includeGroupByRegex("""^top\.theillusivec4(?:\..+$|$)""")
            }
        }
        maven {
            name = "FTB"
            url = uri("https://maven.saps.dev/releases")
            content {
                includeGroupByRegex("""^dev\.latvian(?:\..+$|$)""")
                includeGroupByRegex("""^dev\.ftb(?:\..+$|$)""")
            }
        }
        mavenCentral {
            content {
                includeGroup("com.google.code.findbugs")
                includeGroup("com.google.guava")
                includeGroup("org.apache")
                includeGroup("org.apache.commons")
                includeGroup("org.apache.logging")
                includeGroup("org.apache.logging.log4j")
                includeGroup("org.jetbrains")
                includeGroup("org.slf4j")
                includeGroup("org.sonatype.oss")
            }
        }
    }
}
