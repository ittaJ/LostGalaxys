package com.jatti.battery

import com.jatti.energy.EnergyAddon
import com.jatti.machine.Machine
import com.jatti.user.User
import org.bukkit.Location


class Battery(owner: User) : Machine(owner, BatteryUtils.getBatteriesForUser(owner).size + 1) {

    //TODO add machines list powered by this battery
    var maxEnergy: Int = 100
    var energyUsage: Int = 0

    init {

        BatteryUtils.addBattery(this)

    }

    companion object {

        fun get(owner: User, whereIs: Location): Battery {

            BatteryUtils.getBatteriesForUser(owner)
                    .filter { it.whereIs == whereIs }
                    .forEach { return it }
            return Battery(owner)
        }
    }

    fun addMaxEnergy(energyToAdd: EnergyAddon) {
        this.maxEnergy = this.maxEnergy + energyToAdd.energyToAdd
    }

}