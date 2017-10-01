package com.jatti.teleporter

import com.jatti.machine.Machine
import com.jatti.user.User
import org.bukkit.Location

class Teleporter(owner: User): Machine(owner){

    val channel:Int = 0
    val location: Location = Location(null, 0.0, 0.0, 0.0)

    companion object {

        //TODO

    }
}