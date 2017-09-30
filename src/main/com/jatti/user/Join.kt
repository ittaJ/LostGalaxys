package com.jatti.user

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class Join:Listener{

    @EventHandler
    fun onJoin(evt:PlayerJoinEvent){

        if(!evt.player.hasPlayedBefore()){

            val u:User = User.get(evt.player.name)

            u.showTutorial()
            u.level = 0
            u.exp = 0.0
            u.money = 500

        }

    }

}