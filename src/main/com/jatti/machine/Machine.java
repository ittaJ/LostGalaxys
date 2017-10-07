package com.jatti.machine;

import com.jatti.user.User;
import org.bukkit.ChatColor;
import org.bukkit.Location;

public class Machine {

    private User owner;
    private boolean isEnabled;
    private String name;
    private int value;
    private double energy;
    private Location whereIs;


    public Machine(User owner, int value) {
        this.owner = owner;
        this.value = value;
    }

    public Machine(User owner) {
        this.owner = owner;
    }

    public Machine(User owner, String name) {

        this.owner = owner;
        this.name = name;

    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public void isEnabled(boolean enabled) {
        this.isEnabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {

        this.energy = energy;

        if (this.energy < 0) this.energy = 0;

    }

    public Location getWhereIs() {
        return whereIs;
    }

    public void setWhereIs(Location whereIs) {
        this.whereIs = whereIs;
    }

    public void removeEnergy(User user, double energy) {
        setEnergy(this.energy - energy);
        user.sendActionBar(3, 5, 3, ChatColor.DARK_RED + "-" + energy + " energii");
    }
}