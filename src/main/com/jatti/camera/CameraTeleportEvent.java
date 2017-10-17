package com.jatti.camera;

import com.jatti.computer.Computer;
import com.jatti.user.User;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Event which is called when player teleports via Camera
 * @author Jatti
 * @version 1.0
 */
public class CameraTeleportEvent extends Event {

    private static HandlerList handlers = new HandlerList();
    private User user;
    private Camera camera;
    private Computer computer;

    /**
     * Creates new CameraTeleportEvent
     * @param user user which is teleporting
     * @param camera camera which is player teleporting to
     * @param computer computer with which camera is connected
     */
    public CameraTeleportEvent(User user, Camera camera, Computer computer) {
        this.user = user;
        this.camera = camera;
        this.computer = computer;
    }

    /**
     * Gets HandlerList (class event needs it)
     * @return HandlerList
     */

    public static HandlerList getHandlerList() {
        return handlers;
    }

    /**
     * Gets Computer
     * @return Computer
     */
    public Computer getComputer() {
        return computer;
    }

    /**
     * Gets camera's owner
     * @return User
     */
    public User getUser() {
        return user;
    }

    /**
     * Gets Camera
     * @return Camera
     */
    public Camera getCamera() {
        return camera;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
