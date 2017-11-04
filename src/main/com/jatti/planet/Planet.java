package com.jatti.planet;

import com.jatti.atmosphere.Atmosphere;
import com.jatti.atmosphere.AtmosphereChangeEvent;
import com.jatti.entity.Entity;
import com.jatti.user.User;
import org.bukkit.Bukkit;

import java.util.List;

/**
 * Class for Planets
 *
 * @author Jatti
 * @version 1.0
 */
public class Planet {

    private String name;
    private Atmosphere atmosphere;
    private User owner;
    private List<Entity> entities;

    /**
     * Creates new planet
     *
     * @param name planet's name
     */
    public Planet(String name) {
        this.name = name;
        PlanetUtils.addPlanet(this);
    }

    /**
     * Gets planet from planets' list
     *
     * @param name planet's name
     * @return Planet
     */
    public static Planet get(String name) {
        for (Planet p : PlanetUtils.getPlanets()) {
            if (p.getName().equals(name)) {
                return p;
            }
        }

        return new Planet(name);
    }

    /**
     * Gets name
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name
     *
     * @param name planet's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets owner
     *
     * @return User
     */
    public User getOwner() {
        return owner;
    }

    /**
     * Sets owner
     *
     * @param owner planet's owner
     */
    public void setOwner(User owner) {
        this.owner = owner;
    }

    /**
     * Gets atmosphere
     *
     * @return Atmosphere
     */
    public Atmosphere getAtmosphere() {
        return atmosphere;
    }

    /**
     * Sets atmosphere
     *
     * @param atmosphere planet's atmosphere
     */
    public void setAtmosphere(Atmosphere atmosphere) {
        this.atmosphere = atmosphere;
    }

    /**
     * Changes atmosphere on planet
     *
     * @param newAtmosphere new atmosphere on planet
     */
    public void changeAtmosphere(Atmosphere newAtmosphere) {
        Bukkit.getPluginManager().callEvent(new AtmosphereChangeEvent(this, atmosphere, newAtmosphere));
    }

    /**
     * Gets entities which can spawn on planet
     *
     * @return List<Entity>
     */
    public List<Entity> getEntities() {
        return entities;
    }

    /**
     * Sets entities which can spawn on planet
     *
     * @param entities list of entities which can spawn on planet
     */
    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    /**
     * Shuffles entities for planet
     */
    public void shuffleEntities() {
        //TODO
    }

    /**
     * Method when planet is creating
     */
    public void onCreate() {
        Bukkit.getPluginManager().callEvent(new PlanetCreateEvent(owner, this));
    }
}