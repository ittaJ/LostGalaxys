package com.jatti.entity

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntitySpawnEvent

class EntityCreate : Listener {

    @EventHandler
    fun onSpawn(evt: EntitySpawnEvent) {

        if (evt.entityType == EntityType.ZOMBIE.type) {

            val e: Entity = Entity.get(EntitiesUtils.getEntities().size + 1)

            evt.entity.remove()
            e.onCreate(evt.location)
        }

    }

    @EventHandler
    fun onCreate(evt: MEntityCreateEvent) {

        evt.entity.shuffle()
        println("Nowy entity na: " + evt.location + " Typ: " + evt.entity.type)
        //TODO Add special abilities for Entities
        //TODO Add mini bosses
    }
}