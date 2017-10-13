package com.jatti.achievements.missions.npc

import org.bukkit.Location
import org.bukkit.entity.Villager
import org.bukkit.inventory.MerchantRecipe
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class Npc(val id:Int, val location:Location){


    init{
        NpcUtils.addNpc(this)
    }

    fun spawn(){
        val z:Villager = location.world.spawn(location, Villager::class.java)
        z.setAI(false)
        z.addPotionEffect(PotionEffect(PotionEffectType.HEAL, Int.MAX_VALUE, Int.MAX_VALUE, false, false))
        z.recipes = ArrayList<MerchantRecipe>()
    }

}