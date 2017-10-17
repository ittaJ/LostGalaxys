package com.jatti.planet;

import com.jatti.atmosphere.Atmosphere;
import com.jatti.atmosphere.AtmosphereChangeEvent;
import com.jatti.entity.Entity;
import com.jatti.user.User;
import org.bukkit.Bukkit;

import java.util.List;

/**
 * Class for Planets
 * @author Jatti
 * @version 1.0
 */
public class Planet {

    private String name;
    private Atmosphere atmosphere;
    private User owner;
    private List<Entity> entities;
    //TODO make it working

    /**
     * Creates new planet
     * @param name planet's name
     */
    public Planet(String name) {
        this.name = name;
        PlanetUtils.addPlanet(this);
    }

    /**
     * Gets planet from planets' list
     * @param name planet's name
     * @return Planet
     */
    public static Planet get(String name) {

        for (Planet p : PlanetUtils.getPlanets()) {

            if (p.getName().equals(name)) return p;

        }

        return new Planet(name);

    }

    /**
     * Gets name
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name
     * @param name planet's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets name
     * @return owner 
     */
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Atmosphere getAtmosphere() {
        return atmosphere;
    }

    public void setAtmosphere(Atmosphere atmosphere) {
        this.atmosphere = atmosphere;
    }

    public void changeAtmosphere(Atmosphere newAtmosphere) {
        Bukkit.getPluginManager().callEvent(new AtmosphereChangeEvent(this, atmosphere, newAtmosphere));
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    public void shuffleEntities() {

    }

    public void onCreate(){

    }

}
