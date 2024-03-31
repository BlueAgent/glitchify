@file:Suppress("PropertyName")

val enabled_platforms: String by project
val quilt_loader_version: String by project
val trinkets_version: String by project
val curios_version: String by project
val ftb_quests_version: String by project

architectury {
    common(enabled_platforms.split(","))
}

loom {
    accessWidenerPath.set(file("src/main/resources/glitchify-vanilla.accesswidener"))
}

dependencies {
    implementation(project(path = ":projects:core", configuration = "shadow"))
    modImplementation("org.quiltmc:quilt-loader:${quilt_loader_version}")
    compileOnly(project(path = ":projects:core", configuration = "shadow"))
    modCompileOnly("dev.emi:trinkets:${trinkets_version}")
    modCompileOnly("top.theillusivec4.curios:curios-forge:${curios_version}:api")
    modCompileOnly("dev.ftb.mods:ftb-quests:${ftb_quests_version}")
}
