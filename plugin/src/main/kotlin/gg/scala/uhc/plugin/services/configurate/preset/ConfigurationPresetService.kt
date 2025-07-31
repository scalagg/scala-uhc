package gg.scala.uhc.plugin.services.configurate.preset

import gg.scala.commons.persist.datasync.DataSyncService
import gg.scala.commons.persist.datasync.DataSyncSource
import gg.scala.flavor.inject.Inject
import gg.scala.flavor.service.Service
import gg.scala.uhc.plugin.ScalaUHCPlugin
import gg.scala.uhc.plugin.services.configurate.configurables
import gg.scala.uhc.plugin.services.scenario.GameScenarioService

/**
 * @author GrowlyX
 * @since 4/23/2023
 */
@Service
object ConfigurationPresetService : DataSyncService<ConfigurationPresetContainer>()
{
    @Inject
    lateinit var plugin: ScalaUHCPlugin

    fun buildPresetFromCurrentSetup(name: String) =
        ConfigurationPreset(
            name = name,
            configMappings = mutableMapOf<String, Any>()
                .apply {
                    configurables
                        .forEach {
                            this[it.name] = it.valueInternal
                        }
                },
            scenariosEnabled = GameScenarioService.scenarios
                .filterValues { it.enabled }
                .keys
        )

    override fun locatedIn() = DataSyncSource.Mongo

    override fun keys() = ConfigurationPresetKeys
    override fun type() = ConfigurationPresetContainer::class.java
}
