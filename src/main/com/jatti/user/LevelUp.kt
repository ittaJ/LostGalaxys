package com.jatti.user

import org.bukkit.ChatColor
import org.bukkit.Instrument
import org.bukkit.Note
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

class LevelUp:Listener{

    @EventHandler
    fun onLevelUp(evt:LevelUpEvent){

        evt.user.sendMessage("" + ChatColor.DARK_GREEN + "Gratulacje! Twoj nastepny poziom to: " + ChatColor.GOLD + evt.newLevel)
        evt.user.player.playNote(evt.user.player.location, Instrument.PIANO, Note.flat(1, Note.Tone.C))

    }

}