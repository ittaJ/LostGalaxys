package com.jatti.entity

import com.jatti.user.User
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

class MEntityDeathEvent(var entity: Entity, var killer: User) : Event(false) {

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
