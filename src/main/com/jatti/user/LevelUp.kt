package com.jatti.user

import com.jatti.achievements.prize.Prize
import org.bukkit.ChatColor
import org.bukkit.Sound
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

class LevelUp : Listener {

    @EventHandler
    fun onLevelUp(evt: LevelUpEvent) {

        evt.user.sendMessage("" + ChatColor.DARK_GREEN + "Gratulacje! Osiagnieto nastepny poziom " + ChatColor.GOLD + evt.newLevel)
        evt.user.player.playSound(evt.user.player.location, Sound.ENTITY_PLAYER_LEVELUP, 0F, 1F)

        Prize.builder().forUser(evt.user).withExp(100.0).withGold(50).build()

        evt.user.checkIfNextLevel()

    }

}