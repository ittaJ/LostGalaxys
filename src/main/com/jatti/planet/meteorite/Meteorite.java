package com.jatti.planet.meteorite;

import com.jatti.planet.Planet;
import org.bukkit.Bukkit;

/**
 * Class for meteorites
 * @author Jatti
 * @version 1.0
 */
public class Meteorite {

    private boolean willHit;
    private Planet planetToHit;
    private int timeLeft;

    /**
     * Creates new Meteorite
     * @param planetToHit planet which meteorite will hit
     */
    public Meteorite(Planet planetToHit){
        this.planetToHit = planetToHit;
    }

    /**
     * Gets planet
     * @return Planet
     */
    public Planet getPlanetToHit() {
        return planetToHit;
    }

    /**
     * If meteorite will hit planet
     * @return boolean
     */
    public boolean willHit() {
        return willHit;
    }

    /**
     * Gets time left to hit
     * @return int
     */
    public int getTimeLeft() {
        return timeLeft;
    }

    /**
     * Sets time left to hit
     * @param timeLeft
     */
    public void setTimeLeft(int timeLeft) {
        this.timeLeft = timeLeft;
    }

    /**
     * Launches new meteorite
     */
    public void launch(){
        Bukkit.getPluginManager().callEvent(new MeteoriteLaunchEvent(this, planetToHit, timeLeft));
    }
}
