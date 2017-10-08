package com.jatti.achievements.missions.npc

import org.bukkit.Location
import org.bukkit.entity.Villager

class Npc(val id:Int, val location:Location){

    init{
        NpcUtils.addNpc(this)
    }

    fun spawn(){
        val z:Villager = location.world.spawn(location, Villager::class.java)
        z.setAI(false)

    }

}