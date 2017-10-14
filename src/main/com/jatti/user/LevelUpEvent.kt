package com.jatti.user

import org.bukkit.event.Event
import org.bukkit.event.HandlerList

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