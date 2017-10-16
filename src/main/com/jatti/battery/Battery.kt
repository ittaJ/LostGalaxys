package com.jatti.battery

import com.jatti.energy.EnergyAddon
import com.jatti.machine.Machine
import com.jatti.user.User
import org.bukkit.Location

/**
 * Battery machine
 * @author Jatti
 * @version 1.1
 *
 * @param owner User which owns this machine
 *
 * maxEnergy - max energy which can be in this battery
 * energyUsage- usage of energy
 */
class Battery(owner: User) : Machine(owner, BatteryUtils.getBatteriesForUser(owner).size + 1) {

    //TODO add machines list powered by this battery
    var maxEnergy: Int = 100
    var energyUsage: Int = 0

    init {

        BatteryUtils.addBattery(this)

    }

    companion object {
        /**
         * Gets Battery in specified location
         *
         * @param owner owner of that battery
         * @param whereIs location of that battery
         */
        fun get(owner: User, whereIs: Location): Battery {

            BatteryUtils.getBatteriesForUser(owner)
                    .filter { it.whereIs == whereIs }
                    .forEach { return it }
            return Battery(owner)
        }
    }

    /**
     * Adds amount of max energy from EnergyAddon
     *
     * @param energyToAdd EnergyAddon
     */
    fun addMaxEnergy(energyToAdd: EnergyAddon) {
        this.maxEnergy = this.maxEnergy + energyToAdd.energyToAdd
    }

}