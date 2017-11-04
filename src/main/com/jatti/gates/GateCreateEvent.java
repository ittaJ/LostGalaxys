package com.jatti.gates;

import com.jatti.user.User;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Event when gate is creating
 *
 * @author Jatti
 * @version 1.0
 */
public class GateCreateEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    private User owner;
    private Gate gate;

    /**
     * Creates new GateCreateEvent
     *
     * @param owner gate's owner
     * @param gate  new gate
     */
    public GateCreateEvent(User owner, Gate gate) {
        this.owner = owner;
        this.gate = gate;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    /**
     * Gets owner
     *
     * @return User
     */
    public User getOwner() {
        return owner;
    }

    /**
     * Gets new gates
     *
     * @return Gate
     */
    public Gate getGate() {
        return gate;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
