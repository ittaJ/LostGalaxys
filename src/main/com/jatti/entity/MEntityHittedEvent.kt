package com.jatti.entity

import com.jatti.user.User
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

class MEntityHittedEvent(var target: Entity, var badguy: User) : Event(false) {

    private val hand: HandlerList = HandlerList()

    override fun getHandlers(): HandlerList {
        return hand
    }

    companion object {

        val handlery:HandlerList = HandlerList()

        @JvmStatic fun getHandlerList():HandlerList{
            return handlery
        }

    }
}