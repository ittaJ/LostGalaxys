package com.jatti.energy.stealer;

import com.jatti.machine.Machine;
import com.jatti.user.User;
import org.bukkit.Bukkit;

/**
 *
 */
public class EnergyStealer extends Machine{

    private Machine machineToSteal;
    private boolean willSteal;

    public EnergyStealer(User owner) {
        super(owner);
    }

    public Machine getMachineToSteal(){
        return machineToSteal;
    }

    public void setMachineToSteal(Machine machineToSteal){
        this.machineToSteal = machineToSteal;
    }

    public boolean willSteal(){
        return willSteal;
    }

    public void setWillSteal(boolean willSteal){
        this.willSteal = willSteal;
    }

    public void steal(){
        Bukkit.getPluginManager().callEvent(new EnergyStealEvent(this));
    }
}
