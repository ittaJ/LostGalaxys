package com.jatti.teleporter

import com.jatti.user.User
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockPlaceEvent

class TeleporterPlace : Listener {


    @EventHandler
    fun onPlace(evt: BlockPlaceEvent) {

        if (evt.blockPlaced.type == Material.WOOL) {

            if (evt.itemInHand.hasItemMeta()) {

                if (evt.itemInHand.itemMeta.displayName.contains("Teleporter")) {

                    val id = TeleporterUtils.getTeleportersForUserInChannel(User.get(evt.player.name), evt.blockPlaced.data.toInt()).size + 1

                    val t = Teleporter.get(evt.blockPlaced.data.toInt(), User.get(evt.player.name), id)
                    t.location = Location(Bukkit.getWorld("world"), evt.blockPlaced.x.toDouble(), (evt.blockPlaced.y + 1).toDouble(), evt.blockPlaced.z.toDouble())
                    evt.player.sendMessage("" + ChatColor.GOLD + "Polaczono teleporter o ID " + t.value + " z kanalem " + t.channel)
                }
            }
        }
    }


}