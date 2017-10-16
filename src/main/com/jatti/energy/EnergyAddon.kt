package com.jatti.energy

/**
 * Addons to max energy in machines
 *
 * @author Jatti
 * @version 1.0
 *
 * @param energyToAdd amount of energy
 */
enum class EnergyAddon(val energyToAdd: Int) {

    SMALL(100), MEDIUM(500), HIGH(1000)

}