package com.jatti.computer

import com.jatti.user.User
import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent

class ComputerChangeName:Listener{

    @EventHandler
    fun onChat(evt:AsyncPlayerChatEvent){

        val u:User = User.get(evt.player.name)

        if(u.isChangingName){

            Computer.get(u).name = evt.message

            u.isChangingName = false
            u.sendOneColorMessage(ChatColor.DARK_GREEN, "Zmieniono nazwe komputera!")

        }

    }

}