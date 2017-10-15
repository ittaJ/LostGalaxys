package com.jatti.camera;

import com.jatti.computer.Computer;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class CameraTeleportEvent extends Event {

    private static HandlerList handlers = new HandlerList();
    private User user;
    private Camera camera;
    private Computer computer;

    public CameraTeleportEvent(User user, Camera camera, Computer computer) {
        this.user = user;
        this.camera = camera;
        this.computer = computer;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public Computer getComputer() {
        return computer;
    }

    public User getUser() {
        return user;
    }

    public Camera getCamera() {
        return camera;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
