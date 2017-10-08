package com.jatti.entity

import org.bukkit.Location
import org.bukkit.event.Event
import org.bukkit.event.HandlerList


class MEntityCreateEvent(val entity: Entity, val location: Location) : Event(false) {

    private val handlery: HandlerList = HandlerList()


    override fun getHandlers(): HandlerList {
        return handlery
    }

    companion object {

        val handlery:HandlerList = HandlerList()

        @JvmStatic fun getHandlerList():HandlerList{
            return handlery
        }

    }

}