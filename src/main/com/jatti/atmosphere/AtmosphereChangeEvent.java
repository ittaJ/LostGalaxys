package com.jatti.atmosphere;

import com.jatti.planet.Planet;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Event when Atmosphere is changing
 *
 * @author Jatti
 * @version 1.0
 */
public class AtmosphereChangeEvent extends Event {

    private static HandlerList handlers = new HandlerList();
    private Planet planet;
    private Atmosphere oldAtmosphere;
    private Atmosphere newAtmosphere;
    private boolean canDestroy;
    private boolean willWork;
    private int changeTime;

    /**
     * Creates new event which can change gravity on planet
     *
     * @param planet        planet where atmosphere is going to change
     * @param oldAtmosphere (if change worked) old atmosphere on planet
     * @param newAtmosphere (if change worked) new atmosphere on planet
     *                      other values like canDestroy, willWork and changeTime are going to be random
     */
    public AtmosphereChangeEvent(Planet planet, Atmosphere oldAtmosphere, Atmosphere newAtmosphere) {
        this.planet = planet;
        this.oldAtmosphere = oldAtmosphere;
        this.newAtmosphere = newAtmosphere;
        this.canDestroy = false;
        this.willWork = true;
        this.changeTime = 20;
        //TODO add random values to canDestroy (canDestroy can destroy your planet), willWork (if atmosphere change will works), changeTime (time which is needed to change atmosphere)

    }

    /**
     * Gets HandlerList (class event needs it)
     *
     * @return HandlerList
     */

    public static HandlerList getHandlerList() {
        return handlers;
    }

    /**
     * Gets planet on which atmosphere is changing
     *
     * @return Planet
     */
    public Planet getPlanet() {
        return planet;
    }

    /**
     * Gets old atmosphere (if change worked)
     *
     * @return Atmosphere
     */
    public Atmosphere getOldAtmosphere() {
        return oldAtmosphere;
    }

    /**
     * Gets new atmosphere (if change worked)
     *
     * @return Atmosphere
     */
    public Atmosphere getNewAtmosphere() {
        return newAtmosphere;
    }

    /**
     * if change of atmosphere can destroy planet
     *
     * @return boolean
     */
    public boolean canDestroy() {
        return this.canDestroy;
    }

    /**
     * if change will work
     *
     * @return boolean
     */
    public boolean willWork() {
        return this.willWork;
    }

    /**
     * change time
     *
     * @return int
     */
    public int getChangeTime() {
        return changeTime;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

}
