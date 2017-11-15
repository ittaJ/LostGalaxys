package com.jatti.planet.meteorite;

import com.jatti.planet.Planet;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Event for destructiong planet by Meteorite
 * @author Jatti
 * @version 1.0
 */
public class MeteoriteDestructionEvent extends Event{

    private static HandlerList handlers = new HandlerList();
    private Planet planet;
    private Meteorite meteorite;

    /**
     * Creates new MeteoriteDestructionEvent
     * @param meteorite
     * @param planet
     */
    public MeteoriteDestructionEvent(Meteorite meteorite, Planet planet){
        this.planet = planet;
        this.meteorite = meteorite;
    }

    /**
     * Gets planet to hit
     * @return Planet
     */
    public Planet getPlanet() {
        return planet;
    }

    /**
     * Gets meteorite which will hit planet
     * @return Meteorite
     */
    public Meteorite getMeteorite() {
        return meteorite;
    }

    public static HandlerList getHandlerList(){
        return handlers;
    }

    @Override
    public HandlerList getHandlers(){
        return handlers;
    }
}
