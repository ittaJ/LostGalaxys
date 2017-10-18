package com.jatti.entity

import com.jatti.user.User
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

/**
 * Event which is called when entity deaths
 * @author Jatti
 * @version 1.0
 *
 * @param entity entity which deaths
 * @param killer entity's killer
 */
class MEntityDeathEvent(var entity: Entity, var killer: User) : Event(false) {

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
