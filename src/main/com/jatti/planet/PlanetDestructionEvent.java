package com.jatti.planet;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Event which is called when Planet is destroing itself
 * @see com.jatti.planet.Planet
 *
 * @author Jatti
 * @version 1.0
 */
public class PlanetDestructionEvent extends Event{

    private static final HandlerList handlers = new HandlerList();
    private Planet planet;
    private PlanetDestructionReason reason;

    /**
     * Creates new PlanetDestructionEvent
     * @param planet which is destroing itself
     * @param reason why planet is being destroyed
     */
    public PlanetDestructionEvent(Planet planet, PlanetDestructionReason reason){
        this.planet = planet;
        this.reason = reason;
    }

    /**
     * Creates new PlanetDestructionEvent
     * @param planet which is destroing itself
     */
    public PlanetDestructionEvent(Planet planet){
        this.planet = planet;
        this.reason = PlanetDestructionReason.OTHER;
    }

    /**
     * Gets planet
     * @return Planet
     */
    public Planet getPlanet(){
        return planet;
    }

    /**
     * Gets reason
     * @return PlanetDestructionReason
     */
    public PlanetDestructionReason getReason(){
        return reason;
    }

    public static HandlerList getHandlerList(){
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
