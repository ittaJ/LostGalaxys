package com.jatti.planet.meteorite;

import com.jatti.planet.Planet;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Event when meteorite is being launched
 * @author Jatti
 * @version 1.0
 */
public class MeteoriteLaunchEvent extends Event{

    private static HandlerList handlers = new HandlerList();
    private Meteorite meteorite;
    private Planet planet;
    private int timeLeft;

    /**
     * Creates new MeteoriteLaunchEvent
     * @param meteorite
     * @param planet
     * @param timeLeft
     */
    public MeteoriteLaunchEvent(Meteorite meteorite, Planet planet, int timeLeft){
        this.meteorite = meteorite;
        this.planet = planet;
        this.timeLeft = timeLeft;
    }

    /**
     * Gets time left to hit
     * @return int
     */
    public int getTimeLeft(){
        return timeLeft;
    }

    /**
     * Gets meteorite which will hit planet
     * @return Meteorite
     */
    public Meteorite getMeteorite() {
        return meteorite;
    }

    /**
     * Gets planet
     * @return Planet
     */
    public Planet getPlanet() {
        return planet;
    }

    public static HandlerList getHandlerList(){
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
