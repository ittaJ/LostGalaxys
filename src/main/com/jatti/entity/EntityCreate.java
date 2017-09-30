package com.jatti.entity;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class EntityCreate implements Listener{

    @EventHandler
    public void onSpawn(EntitySpawnEvent evt){

        Entity.Companion.get(EntitiesUtils.getEntities().size()+1).onCreate(evt.getLocation());

    }

    @EventHandler
    public void onCreate(MEntityCreateEvent evt){

        //TODO Add changing org.bukkit.entity.EntityType for Entities
        //TODO Add special abilities for Entities
        //TODO Add mini bosses

    }
}
