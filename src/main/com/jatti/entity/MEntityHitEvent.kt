package com.jatti.entity

import com.jatti.user.User
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

/**
 * Event which is called when entity hits player
 * @author Jatti
 * @version 1.0
 *
 * @param target user which is entity's target
 * @param hit entity that hit player
 */
class MEntityHitEvent(val target: User, val hit: Entity) : Event(false) {

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