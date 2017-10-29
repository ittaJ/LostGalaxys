package com.jatti.atmosphere;

import java.util.ArrayList;
import java.util.List;

/**
 * Utils for Atmosphere
 */
public class AtmosphereUtils {

    private static final List<Atmosphere> atmospheres = new ArrayList<Atmosphere>();

    /**
     * Gets list of all atmospheres
     * @return List<Atmosphere>
     */
    public static List<Atmosphere> getAtmospheres() {
        return atmospheres;
    }

    /**
     * Adds atmosphere to list
     * @param atmosphere atmosphere to add
     */
    public static void addAtmosphere(Atmosphere atmosphere) {
        if (!atmospheres.contains(atmosphere)) {
            atmospheres.add(atmosphere);
        }
    }

    /**
     * Removes atmosphere from list
     * @param atmosphere atmosphere to remove
     */
    public static void removeAtmosphere(Atmosphere atmosphere) {
        if (atmospheres.contains(atmosphere)) {
            atmospheres.remove(atmosphere);
        }
    }
}