package com.jatti.user

import com.jatti.achievements.missions.ViewTutorialMission
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

/**
 * Listener when player joins server for the first time
 * @author Jatti
 * @version 1.0
 *
 */
class Join : Listener {

    @EventHandler
    fun onJoin(evt: PlayerJoinEvent) {

        if (!evt.player.hasPlayedBefore()) {

            val u: User = User.get(evt.player.name)

            ViewTutorialMission().onGet(u)
            u.level = 0
            u.exp = 0.0
            u.gold = 500

        }

    }

}