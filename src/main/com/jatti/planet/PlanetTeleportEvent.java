package com.jatti.planet;

import com.jatti.user.User;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Event for teleporting to planet
 *
 * @author Jatti
 * @version 1.0
 */
public class PlanetTeleportEvent extends Event {

    private static HandlerList handlerList = new HandlerList();
    private User user;
    private Planet planet;

    /**
     * Creates new PlanetTeleportEvent
     *
     * @param user   user to teleport
     * @param planet planet on which user will be
     */
    public PlanetTeleportEvent(User user, Planet planet) {
        this.user = user;
        this.planet = planet;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
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
     * Gets planet
     *
     * @return Planet
     */
    public Planet getPlanet() {
        return planet;
    }

    public HandlerList getHandlers() {
        return handlerList;
    }
}
