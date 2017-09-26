package com.jatti.user

import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

class LevelUp:Listener{

    @EventHandler
    fun onLevelUp(evt:LevelUpEvent){

        evt.user.sendMessage("" + ChatColor.DARK_GREEN + "Gratulacje! Twoj nastepny poziom to: " + ChatColor.GOLD + evt.newLevel)



    }

}