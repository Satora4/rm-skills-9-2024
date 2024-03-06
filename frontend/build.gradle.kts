import com.github.gradle.node.NodeExtension
import com.github.gradle.node.npm.task.NpmTask

plugins {
    id("com.github.node-gradle.node") version "7.0.2"
}

configure<NodeExtension> {
    version.set("21.6.2")
    npmVersion.set("10.2.4")
    download.set(true)
}

tasks.register<NpmTask>("npmCi") {
  inputs.file("package-lock.json")
  inputs.file("package-lock.json")
  outputs.dir("node_modules")
  args = listOf("ci")
}

tasks.register<NpmTask>("serveFrontend") {
    dependsOn("npmCi")
    args = listOf("run", "ng", "serve")
}
