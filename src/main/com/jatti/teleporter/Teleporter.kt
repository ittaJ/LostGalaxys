package com.jatti.teleporter

import com.jatti.machine.Machine
import com.jatti.user.User

import org.bukkit.Location

class Teleporter(owner: User, val channel: Int, val id: Int) : Machine(owner) {

    var location: Location = Location(null, 0.0, 0.0, 0.0)

    companion object {

        fun get(channel: Int, owner: User, id: Int): Teleporter {

            TeleporterUtils.getTeleportersForUser(owner).filter { it.channel == channel }.filter { it.id == id }.forEach { return it }

            return Teleporter(owner, channel, id)
        }

    }
}