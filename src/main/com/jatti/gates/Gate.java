package com.jatti.gates;

import com.jatti.machine.Machine;
import com.jatti.user.User;
import org.bukkit.Bukkit;

/**
 * Class for Gate Machine
 *
 * @author Jatti
 * @version 1.0
 */
public class Gate extends Machine {

    private int level;
    private GateLook look;

    /**
     * Creates new Gate
     *
     * @param owner gate's owner
     */
    public Gate(User owner) {
        super(owner);
    }

    /**
     * Gets gate's level
     *
     * @return int
     */
    public int getLevel() {
        return level;
    }

    /**
     * Sets gate's level
     *
     * @param level new gate's level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Gets gate's look
     *
     * @return GateLook
     */
    public GateLook getLook() {
        return look;
    }

    /**
     * Sets gate's look
     *
     * @param look new gate's look
     */
    public void setLook(GateLook look) {
        this.look = look;
    }

    /**
     * Checks if gate is able to level up
     */
    public void nextLevel() {
        Bukkit.getPluginManager().callEvent(new GateLevelUpEvent(this, level + 1));
    }
}
