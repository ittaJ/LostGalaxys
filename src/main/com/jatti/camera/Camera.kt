package com.jatti.camera

import com.jatti.machine.Machine
import com.jatti.user.User
import org.bukkit.Location
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftArmorStand

class Camera(owner: User) : Machine(owner, CameraUtils.getCamerasForUser(owner).size + 1) {

    var where: Location? = null
    var armorStand: CraftArmorStand? = null
    var isConnected: Boolean = false


    init {

        CameraUtils.addCamera(this)

    }

    companion object {


        operator fun get(user: User, value: Int): Camera {

            CameraUtils.getCamerasForUser(user)
                    .filter { it.value == value }
                    .forEach { return it }

            return Camera(user)

        }
    }

}
