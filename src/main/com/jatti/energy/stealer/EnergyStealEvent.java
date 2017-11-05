package com.jatti.energy.stealer;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class EnergyStealEvent extends Event{

    private static final HandlerList handlers = new HandlerList();
    private EnergyStealer stealer;

    public EnergyStealEvent(EnergyStealer stealer){
        this.stealer = stealer;
    }

    public EnergyStealer getStealer() {
        return stealer;
    }

    public static HandlerList getHandlerList(){
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
