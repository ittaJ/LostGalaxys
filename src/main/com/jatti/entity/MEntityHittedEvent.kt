package com.jatti.entity

import com.jatti.user.User
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

/**
 * Event which is called when player hit entity
 * @author Jatti
 * @version 1.0
 *
 * @param target entity which was hit
 * @param badguy user that hit entity
 */
class MEntityHittedEvent(var target: Entity, var badguy: User) : Event(false) {

    private val hand: HandlerList = HandlerList()

    override fun getHandlers(): HandlerList {
        return hand
    }

    companion object {

        val handlery: HandlerList = HandlerList()

        @JvmStatic
        fun getHandlerList(): HandlerList {
            return handlery
        }

    }
}