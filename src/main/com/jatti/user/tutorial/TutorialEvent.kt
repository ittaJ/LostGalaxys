package com.jatti.user.tutorial

import com.jatti.user.User
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

/**
 * Event which is called when Player starts watching tutorial
 * @author Jatti
 * @version 1.0
 * @param user user who is watching tutorial
 */

class TutorialEvent(val user: User): Event() {

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