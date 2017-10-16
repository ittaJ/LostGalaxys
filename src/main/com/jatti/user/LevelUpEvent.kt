package com.jatti.user

import org.bukkit.event.Event
import org.bukkit.event.HandlerList

/**
 * Event which is called when User has new level
 * @author Jatti
 * @version 1.0
 * @param user User which has new level
 * @param oldLevel user's old level
 * @param newLevel user's new level
 *
 */
class LevelUpEvent(var user: User, var oldLevel: Int, var newLevel: Int) : Event(false) {

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