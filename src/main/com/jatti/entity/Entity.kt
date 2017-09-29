package com.jatti.entity

import com.jatti.user.User
import org.bukkit.Bukkit

class Entity(var type:EntityType) {

    var level: Int = 0
    var expToDrop: Double = 0.0
    var id: Int = 0

    fun onHit(hitted: Boolean, g: User){

        return if (hitted){
            Bukkit.getPluginManager().callEvent(MEntityHittedEvent(this, g))
        }else{
            Bukkit.getPluginManager().callEvent(MEntityHitEvent(g, this))
        }

    }

        fun onCreate() {
            Bukkit.getPluginManager().callEvent(MEntityCreateEvent(this))
        }

        fun onDeath(killer: User) {
            Bukkit.getPluginManager().callEvent(MEntityDeathEvent(this, killer))
        }


        init {
            this.id = EntitiesUtils.getEntities().size + 1
            EntitiesUtils.addEntity(this)
            onCreate()
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