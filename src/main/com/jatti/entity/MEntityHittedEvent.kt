package com.jatti.entity

import com.jatti.user.User
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

class MEntityHittedEvent(target:Entity, badguy: User): Event(false){

    private val hand:HandlerList = HandlerList()
    private var targ:Entity = target
    private var bad:User = badguy

    init{
        this.targ = target
        this.bad = badguy
    }

    fun getTarget():Entity{
        return targ
    }

    fun getHitting():User{
        return bad
    }

    override fun getHandlers(): HandlerList {
        return hand
    }

}