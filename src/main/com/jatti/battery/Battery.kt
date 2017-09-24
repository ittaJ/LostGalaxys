package com.jatti.battery

import com.jatti.energy.EnergyAddon
import com.jatti.machine.Machine
import com.jatti.user.User

class Battery(owner: User):Machine(owner, BatteryUtils.getBatteriesForUser(owner).size + 1){

    var maxEnergy:Int = 100
    var energyUsage:Int = 0

    init{

        BatteryUtils.addBattery(this)

    }

    companion object {

        fun get(owner:User, value:Int):Battery{

            for(b in BatteryUtils.getBatteriesForUser(owner)){

                if(b.value == value) return b

            }
            return Battery(owner)
        }



    }

    fun addMaxEnergy(energyToAdd:EnergyAddon){
        this.maxEnergy = this.maxEnergy+energyToAdd.energyToAdd
    }

}