package com.jatti.entity

import org.bukkit.event.Event
import org.bukkit.event.HandlerList


class MEntityCreateEvent(var entity: Entity): Event(false){

    //TODO Check if its working
    private val handlery: HandlerList = HandlerList()


    override fun getHandlers(): HandlerList {
        return handlery
    }

}