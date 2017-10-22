package com.jatti.battery

import com.jatti.user.User
import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent

/**
 * Listener when player clicks battery
 * @author Jatti
 * @version 1.1
 */
class BatteryClick : Listener {

    @EventHandler
    fun onClick(evt: PlayerInteractEvent) {

        val u: User = User.get(evt.player.name)

        for(b in BatteryUtils.getBatteries()) {

            if(BatteryUtils.getBatteriesForUser(u).contains(b)) {

                if (evt.action == Action.RIGHT_CLICK_BLOCK) {

                    u.sendMessage("" + ChatColor.GREEN + "Energia w baterii: " + ChatColor.GOLD + b.energy + "/" + b.maxEnergy)
                    u.sendMessage("" + ChatColor.GREEN + "Zuzycie energii: " + ChatColor.GOLD + b.energyUsage)

                }

                if (evt.action == Action.LEFT_CLICK_BLOCK) {

                    //TODO add connecting to battery

                }
            }else{

                u.sendMessage("" + ChatColor.RED + "Nie mozesz uzyc nie swojej baterii!")
            }

        }
    }

}