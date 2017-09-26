package com.jatti.user

import org.bukkit.event.Event
import org.bukkit.event.HandlerList

class TutorialEvent(var user:User):Event(false){

    private val handlery: HandlerList = HandlerList()

    override fun getHandlers(): HandlerList {
        return handlery
    }

}