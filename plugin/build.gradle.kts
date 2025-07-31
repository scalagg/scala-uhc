plugins {
    java
}

tasks.withType<JavaCompile> {
    options.compilerArgs.add("-parameters")
    options.fork()
    options.encoding = "UTF-8"
}

dependencies {
    api(project(":shared"))
    compileOnly(fileTree("lib") {
        include("*.jar")
    })
    kapt("gg.scala.commons:bukkit:4.0.7")
    compileOnly("gg.scala.game.extensions:scala-core-game-extensions:1.3.0")
    compileOnly("gg.scala.cgs:game:1.4.1")
}
