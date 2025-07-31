package gg.scala.uhc.plugin

/**
 * @author GrowlyX
 * @since 5/3/2023
 */
val autonomous: Boolean
    get() = ScalaUHCPlugin.instance
        .config<ScalaUHCConfig>()
        .autonomous

val config: ScalaUHCConfig
    get() = ScalaUHCPlugin.instance
        .config<ScalaUHCConfig>()
