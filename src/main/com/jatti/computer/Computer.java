package com.jatti.computer;

import com.jatti.camera.Camera;
import com.jatti.machine.Machine;
import com.jatti.user.User;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

public class Computer extends Machine {

    private Location where;
    private List<Camera> cameras;

    public Computer(User owner) {

        super(owner, "Komputer");

        ComputerUtils.addComputer(this);
    }

    public static Computer getFromLocation(Location where) {

        for (Computer c : ComputerUtils.getComputers()) {

            if (c.getWhere().equals(where)) return c;

        }

        return null;

    }

    public static Computer get(User owner) {

        for (Computer c : ComputerUtils.getComputers()) {

            if (c.getOwner().equals(owner)) return c;

        }

        return new Computer(owner);

    }

    public Location getWhere() {
        return where;
    }

    public void setWhere(Location where) {
        this.where = where;
    }

    public List<Camera> getCameras() {
        if (cameras == null) cameras = new ArrayList<Camera>();
        return cameras;
    }

    public void setCameras(List<Camera> cameras) {
        this.cameras = cameras;
    }

    public void addCamera(Camera c) {
        if (!cameras.contains(c)) {
            cameras.add(c);
            c.setConnected(true);
        }
    }

}
