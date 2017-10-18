package com.jatti.entity

import org.bukkit.Location
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

/**
 * Event which is called when entity is creating
 * @author Jatti
 * @version 1.0
 *
 * @param entity entity which is creting
 * @param location location where entity is creating
 */
class MEntityCreateEvent(val entity: Entity, val location: Location) : Event(false) {

    private val handlery: HandlerList = HandlerList()


    override fun getHandlers(): HandlerList {
        return handlery
    }

    companion object {

        val handlery: HandlerList = HandlerList()

        @JvmStatic
        fun getHandlerList(): HandlerList {
            return handlery
        }

    }

}