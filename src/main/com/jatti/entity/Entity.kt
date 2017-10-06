package com.jatti.entity

import com.jatti.user.User
import org.bukkit.Bukkit
import org.bukkit.Location
import java.util.*

class Entity(var type:EntityType) {

    //TODO add pets
    var level: Int = 0
    var expToDrop: Double = 0.0
    var id: Int = 0
    var life:Int = 0

    fun onHit(hitted: Boolean, g: User){

        return if (hitted){
            Bukkit.getPluginManager().callEvent(MEntityHittedEvent(this, g))
        }else{
            Bukkit.getPluginManager().callEvent(MEntityHitEvent(g, this))
        }

    }

        fun onCreate(location:Location) {
            Bukkit.getPluginManager().callEvent(MEntityCreateEvent(this, location))
        }

        fun onDeath(killer: User) {
            Bukkit.getPluginManager().callEvent(MEntityDeathEvent(this, killer))
        }

        fun shuffle(){

            type = EntitiesUtils.getRandType()
            //TODO add better leveling system
            level = Random().nextInt(10)
            expToDrop = Random().nextDouble()+level
            life = level*5

        }

        init {
            EntitiesUtils.addEntity(this)
        }

        companion object {

            fun get(id: Int): Entity {

                EntitiesUtils.getEntities()
                        .filter { it.id == id }
                        .forEach { return it }

                return Entity(EntityType.RANDOM)

            }


}
}