package com.jatti.entity

import com.jatti.user.User
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

class MEntityDeathEvent(entity:Entity, killer:User):Event(false){

   private val handlery:HandlerList = HandlerList()
   private var ent:Entity = entity
   private var kill:User = killer

    init{
        this.ent = entity
        this.kill = killer
    }

    fun getEntity():Entity{
        return ent
    }

    fun getKiller():User{
        return kill
    }

    override fun getHandlers():HandlerList{
        return handlery
    }
}
