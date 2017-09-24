package com.jatti.planet;

import java.util.ArrayList;
import java.util.List;

public class PlanetUtils {

    private static List<Planet> planets = new ArrayList<Planet>();

    public static List<Planet> getPlanets(){
        if(planets == null) planets = new ArrayList<Planet>();
        return planets;
    }

    public static void addPlanet(Planet p){
        if(!planets.contains(p)) planets.add(p);
    }

    public static void removePlanet(Planet p){
        if(planets.contains(p)) planets.remove(p);
    }

}
