package com.jatti.gates;

import com.jatti.user.User;
import org.bukkit.Location;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Event for teleporting by Gate
 *
 * @author Jatti
 * @version 1.0
 */
public class GateTeleportEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    private User user;
    private Gate gate;
    private Location where;

    /**
     * Creates new GateTeleportEvent
     *
     * @param user  which will be teleporter
     * @param gate  by which user will be teleporter
     * @param where user will be teleported
     */
    public GateTeleportEvent(User user, Gate gate, Location where) {
        this.user = user;
        this.gate = gate;
        this.where = where;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    /**
     * Gets user
     *
     * @return User
     */
    public User getUser() {
        return user;
    }

    /**
     * Gets gate
     *
     * @return Gate
     */
    public Gate getGate() {
        return gate;
    }

    /**
     * Gets where
     *
     * @return Location
     */
    public Location getWhere() {
        return where;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
