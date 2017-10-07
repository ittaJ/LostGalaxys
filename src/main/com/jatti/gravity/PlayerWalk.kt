package com.jatti.gravity

import com.jatti.user.User
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerMoveEvent

class PlayerWalk : Listener {

    @EventHandler
    fun onWalk(evt: PlayerMoveEvent) {

        val user: User = User.get(evt.player.name)

        TODO("Finish planets and make gravity on them")
    }

}