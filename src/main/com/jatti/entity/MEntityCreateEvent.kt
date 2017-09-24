package com.jatti.entity

import org.bukkit.event.Event
import org.bukkit.event.HandlerList


class MEntityCreateEvent(entity:Entity): Event(false){

    //TODO Check if its working
    private val handlery: HandlerList = HandlerList()
    private var ent:Entity? = null

    init{
        ent = entity
    }



    override fun getHandlers(): HandlerList {
        return handlery
    }



    fun getEntity():Entity?{
        return ent
    }
}