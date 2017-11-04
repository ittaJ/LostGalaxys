package com.jatti.planet;

import com.jatti.user.User;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Event when planet is creating
 *
 * @author Jatti
 * @version 1.0
 */
public class PlanetCreateEvent extends Event {

    private static HandlerList handlers = new HandlerList();
    private User owner;
    private Planet planet;

    /**
     * Creates new PlanetCreateEvent
     *
     * @param owner planet's owner
     */
    public PlanetCreateEvent(User owner, Planet planet) {
        this.owner = owner;
        this.planet = planet;
    }

    /**
     * Gets HandlerList (class event needs it)
     *
     * @return HandlerList
     */

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    /**
     * gets planet's owner
     *
     * @return User
     */
    public User getOwner() {
        return owner;
    }

    /**
     * Gets planet
     *
     * @return Planet
     */
    public Planet getPlanet() {
        return planet;
    }
}
