package com.jatti.battery

import com.jatti.Gui
import com.jatti.user.User
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEvent

/**
 * Listener when player clicks battery
 * @author Jatti
 * @version 1.0
 */
class BatteryClick : Listener {

    @EventHandler
    fun onClick(evt: PlayerInteractEvent) {

        val u: User = User.get(evt.player.name)

        if (BatteryUtils.getBatteriesForUser(u).isNotEmpty()) {


            BatteryUtils.getBatteriesForUser(u)
                    .filter { it.whereIs == evt.clickedBlock.location }
                    .forEach { Gui.openEnergyGui(u, it.whereIs) }

        }

    }

}