package com.jatti.entity

import com.jatti.user.User
import org.bukkit.Bukkit

class Entity(type:EntityType) {

    var level: Int = 0
    var expToDrop: Double = 0.0
    var id: Int = 0

    fun onHit(hitted: Boolean, g:User){

        return if (hitted){
            Bukkit.getPluginManager().callEvent(MEntityHittedEvent(this, g))
        }else{
            TODO("Make another event if entity hit user")
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

            for (e in EntitiesUtils.getEntities()) {

                if (e.id == id) return e

            }

            return Entity(EntityType.RANDOM)

        }


    }
}