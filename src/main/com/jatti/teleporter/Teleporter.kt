package com.jatti.teleporter

import com.jatti.machine.Machine
import com.jatti.user.User

import org.bukkit.Location

/**
 * Teleporter machine
 *
 * @author Jatti
 * @version 1.0
 *
 * @param owner teleporter's owner
 * @param channel teleporter's channel - e.g youve got 5 teleporters 3 of them are in channel 1 and two of them are in channel 2
 * when you step on one from channel 1 you will teleport to another one from channel 1, but never to teleporter from channel 2
 * @param id teleporter's id
 *
 * location - teleporter's location
 */
class Teleporter(owner: User, val channel: Int, val id: Int) : Machine(owner) {

    var location: Location = Location(null, 0.0, 0.0, 0.0)

    companion object {

        /**
         * Gets teleporter from list
         *
         * @param channel teleporter's channel
         * @param owner teleporter's owner
         * @param id teleporter's id
         *
         * @return Teleporter
         */
        fun get(channel: Int, owner: User, id: Int): Teleporter {

            TeleporterUtils.getTeleportersForUser(owner).filter { it.channel == channel }.filter { it.id == id }.forEach { return it }

            return Teleporter(owner, channel, id)
        }

    }
}