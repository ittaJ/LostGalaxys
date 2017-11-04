package com.jatti.gates;


import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Event that is called when gate level ups
 *
 * @author Jatti
 * @version 1.0
 * @see com.jatti.gates.Gate
 */
public class GateLevelUpEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    private Gate gate;
    private int level;

    /**
     * Creates new GateLevelUpEvent
     *
     * @param gate  to levelup
     * @param level next level
     */
    public GateLevelUpEvent(Gate gate, int level) {
        this.gate = gate;
        this.level = level;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    /**
     * Gets gate to levelup
     *
     * @return Gate
     */
    public Gate getGate() {
        return gate;
    }

    /**
     * Gets next level
     *
     * @return int
     */
    public int getLevel() {
        return level;
    }

    public HandlerList getHandlers() {
        return handlers;
    }
}
