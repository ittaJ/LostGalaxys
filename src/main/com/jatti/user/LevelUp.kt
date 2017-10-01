package com.jatti.user

import com.jatti.achievements.prize.Prize
import org.bukkit.ChatColor
import org.bukkit.Instrument
import org.bukkit.Note
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

class LevelUp:Listener{

    @EventHandler
    fun onLevelUp(evt:LevelUpEvent){

        evt.user.sendMessage("" + ChatColor.DARK_GREEN + "Gratulacje! Osiagnieto nastepny poziom " + ChatColor.GOLD + evt.newLevel)
        evt.user.player.playSound(evt.user.player.location, Sound.ENTITY_PLAYER_LEVELUP, 0F, 1F)

        val p:Prize = Prize.get(evt.newLevel)


        for(i in p.items){
            evt.user.player.inventory.addItem(i)
        }

        evt.user.exp+=p.xp
        evt.user.gold+=p.gold

        evt.user.checkIfNextLevel()

    }

}