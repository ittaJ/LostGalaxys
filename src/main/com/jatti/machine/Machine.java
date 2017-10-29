package com.jatti.machine;

import com.jatti.user.User;
import org.bukkit.ChatColor;
import org.bukkit.Location;

/**
 * Class that need to be extended by all types of machine e.g
 * 
 * @see com.jatti.computer.Computer
 * @author Jatti
 * @version 1.0
 *
 */
public class Machine {

    private User owner;
    private boolean isEnabled;
    private String name;
    private int value;
    private double energy;
    private Location whereIs;

    /**
     * Creates new machine
     * 
     * @param owner
     *            machine's owner
     * @param value
     *            machine's ID
     */
    public Machine(User owner, int value) {
        this.owner = owner;
        this.value = value;
    }

    /**
     * Creates new machine (only if player can have one of that type of machine)
     * 
     * @param owner
     *            machine's owner
     */
    public Machine(User owner) {
        this.owner = owner;
    }

    /**
     * Creates new machine
     * 
     * @param owner
     *            machine's owner
     * @param name
     *            machine's name
     */
    public Machine(User owner, String name) {
        this.owner = owner;
        this.name = name;
    }

    /**
     * Gets ID of this machine
     * 
     * @return int
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets ID for this machine
     * 
     * @param value
     *            new machine's ID
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Gets machine owner
     * 
     * @return User
     */
    public User getOwner() {
        return owner;
    }

    /**
     * Sets machine owner
     * 
     * @param owner
     *            machine owner
     */
    public void setOwner(User owner) {
        this.owner = owner;
    }

    /**
     * Gets if machine is enabled
     * 
     * @return boolean
     */
    public boolean isEnabled() {
        return this.isEnabled;
    }

    /**
     * Sets if machine is enabled
     * 
     * @param enabled
     *            if machine is enabled
     */
    public void isEnabled(boolean enabled) {
        this.isEnabled = enabled;
    }

    /**
     * Gets machine's name
     * 
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Sets machine's name
     * 
     * @param name
     *            new machine's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets machine's energy
     * 
     * @return double
     */
    public double getEnergy() {
        return energy;
    }

    /**
     * Sets energy that can't be less than 0
     * 
     * @param energy
     *            amount of energy
     */
    public void setEnergy(double energy) {
        this.energy = energy < 0 ? 0 : energy;
    }

    /**
     * Gets location where machine is
     * 
     * @return Location
     */
    public Location getWhereIs() {
        return whereIs;
    }

    /**
     * Sets location where machine is
     * 
     * @param whereIs
     *            new location
     */
    public void setWhereIs(Location whereIs) {
        this.whereIs = whereIs;
    }

    /**
     * Removes energy from machine
     * 
     * @param user
     *            machine's owner
     * @param energy
     *            energy to remove
     */
    public void removeEnergy(User user, double energy) {
        setEnergy(this.energy - energy);
        user.sendActionBar(3, 5, 3, ChatColor.DARK_RED + "-" + energy + " energii");
    }
}