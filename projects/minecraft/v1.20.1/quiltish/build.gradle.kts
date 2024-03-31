@file:Suppress("PropertyName")

import org.gradle.util.Path

val enabled_platforms: String by project
val minecraft_version: String by project
val quilt_loader_version: String by project
val quilted_fabric_api_version: String by project
val trinkets_version: String by project
val ftb_quests_version: String by project

val parentPath = Path.path(project.path).parent!!
val vanillaPath = parentPath.child("vanilla").path!!
evaluationDependsOn(vanillaPath)

architectury {
    common(enabled_platforms.split(","))
}

loom {
    accessWidenerPath.set(project(vanillaPath).loom.accessWidenerPath)
}

dependencies {
    modImplementation("org.quiltmc:quilt-loader:${quilt_loader_version}")
    modApi("org.quiltmc.quilted-fabric-api:quilted-fabric-api:${quilted_fabric_api_version}-${minecraft_version}")
    compileOnly(project(path = ":projects:core", configuration = "shadow"))
    compileOnly(project(path = vanillaPath, configuration = "namedElements")) { isTransitive = false }
    modCompileOnly("dev.emi:trinkets:${trinkets_version}")
    modCompileOnly("dev.ftb.mods:ftb-quests:${ftb_quests_version}")
}
