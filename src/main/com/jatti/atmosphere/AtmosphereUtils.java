package com.jatti.atmosphere;

import java.util.ArrayList;
import java.util.List;

public class AtmosphereUtils {

    private static List<Atmosphere> atmospheres = new ArrayList<Atmosphere>();


    public static List<Atmosphere> getAtmospheres() {
        if (atmospheres == null) atmospheres = new ArrayList<Atmosphere>();
        return atmospheres;
    }

    public static void addAtmosphere(Atmosphere a) {

        if (!atmospheres.contains(a)) atmospheres.add(a);

    }

    public static void removeAtmosphere(Atmosphere a) {
        if (atmospheres.contains(a)) atmospheres.remove(a);
    }

}
