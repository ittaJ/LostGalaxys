package com.jatti.computer;

import com.jatti.camera.Camera;
import com.jatti.machine.Machine;
import com.jatti.user.User;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Computer machine
 *
 * @author Jatti
 * @version 1.0
 */
public class Computer extends Machine {

    private Location where;
    private List<Camera> cameras;

    /**
     * Creates new Computer
     *
     * @param owner computer's owner
     */
    public Computer(User owner) {
        super(owner, "Komputer");
        ComputerUtils.addComputer(this);
    }

    /**
     * Gets computer from location
     *
     * @param where computer's location
     * @return Computer
     */
    public static Computer getFromLocation(Location where) {
        for (Computer c : ComputerUtils.getComputers()) {
            if (c.getWhere().equals(where)) {
                return c;
            }
        }

        return null;
    }

    /**
     * Gets user's computer
     *
     * @param owner computer's owner
     * @return Computer
     */
    public static Computer get(User owner) {
        for (Computer c : ComputerUtils.getComputers()) {
            if (c.getOwner().equals(owner)) {
                return c;
            }
        }

        return new Computer(owner);
    }

    /**
     * Gets computer's location
     *
     * @return Location
     */
    public Location getWhere() {
        return where;
    }

    /**
     * Sets computer's location
     *
     * @param where computer's location
     */
    public void setWhere(Location where) {
        this.where = where;
    }

    /**
     * Gets all cameras connected with computer
     *
     * @return List<Camera>
     */
    public List<Camera> getCameras() {
        if (cameras == null) {
            cameras = new ArrayList<Camera>();
        }

        return cameras;
    }

    /**
     * Adds camera to list with cameras
     *
     * @param camera camera to add
     */
    public void addCamera(Camera camera) {
        if (!cameras.contains(camera)) {
            cameras.add(camera);
            camera.setConnected(true);
        }
    }
}