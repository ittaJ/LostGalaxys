package com.jatti.computer

import com.jatti.user.User
import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent

/**
 * Listener when player is changing computer's name
 * @author Jatti
 * @version 1.0
 */
class ComputerChangeName : Listener {

    @EventHandler
    fun onChat(evt: AsyncPlayerChatEvent) {

        val u: User = User.get(evt.player.name)

        if (ComputerGuiInteract.changingName.containsKey(u)) {

            Computer.get(u).name = evt.message

            ComputerGuiInteract.changingName.remove(u)
            u.sendMessage("" + ChatColor.DARK_GREEN + "Zmieniono nazwe komputera!")

        }

    }

}