package com.jatti.planet;

import com.jatti.user.User;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlanetCreateEvent extends Event {

    private static HandlerList handlers;
    private User owner;

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public User getOwner() {
        return owner;
    }

    public HandlerList getHandlers() {
        return handlers;
    }
}
