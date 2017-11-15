package com.jatti.gates.dimension.wormhole

import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.entity.ArmorStand

/**
 * Class for wormholes
 * @author Jatti
 * @version 1.0
 *
 * @param whereIs where wormhole is
 * @param whereTp where wormhole will tp
 */
class Wormhole(var whereIs: Location?, val whereTp: Location?){

    val timeToDisappear: Int = 100
    var armorStand: ArmorStand? = null

    companion object {
        /**
         * Creates new wormhole
         * @param whereIs where wormhole is
         * @param whereTp where wormhole will tp
         */
        @JvmStatic
        fun create(whereIs: Location, whereTp: Location): Wormhole{
            val w = Wormhole(whereIs, whereTp)
            w.armorStand = Bukkit.getWorld("world").spawn(whereIs, ArmorStand::class.java)
            w.armorStand!!.isVisible = false
            w.armorStand!!.setBasePlate(false)
            w.armorStand!!.setAI(false)
            return w
        }
    }

    /**
     * Destroys wormhole
     */
    fun destroy(){
        armorStand!!.remove()
    }

    /**
     * Changes wormhole's location
     */
    fun changeLocation(newLocation: Location){
        whereIs = newLocation
        if(armorStand == null){
            destroy()
        }
        armorStand!!.teleport(newLocation)
    }
}
