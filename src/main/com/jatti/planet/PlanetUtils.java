package com.jatti.planet;

import java.util.ArrayList;
import java.util.List;

/**
 * Utils for Planet
 */
public class PlanetUtils {

    private static final List<Planet> planets = new ArrayList<Planet>();

    /**
     * Gets list of all planets
     * 
     * @return List<Planet>
     */
    public static List<Planet> getPlanets() {
        return planets;
    }

    /**
     * Adds Planet to list
     * 
     * @param p
     *            planet to add
     */
    public static void addPlanet(Planet p) {
        if (!planets.contains(p)) {
            planets.add(p);
        }
    }

    /**
     * Removes Planet from list
     * 
     * @param p
     *            planet to remove
     */
    public static void removePlanet(Planet p) {
        if (planets.contains(p)) {
            planets.remove(p);
        }
    }
}