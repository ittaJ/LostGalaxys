package com.jatti.gates;

import org.bukkit.block.Block;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for gate's look
 *
 * @author Jatti
 * @version 1.0
 */
public class GateLook {

    private String name;
    private GateType type;
    private List<Block> blocks = new ArrayList<Block>();
    private Block core;
    private int x;
    private int y;

    /**
     * Crates new GateLook
     *
     * @param name look's name
     */
    public GateLook(String name) {
        this.name = name;
    }

    /**
     * Gets look's name
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Sets look's name
     *
     * @param name new look's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets type for this look
     *
     * @return GateType
     */
    public GateType getType() {
        return type;
    }

    /**
     * Sets type for this look
     *
     * @param type new look's type
     */
    public void setType(GateType type) {
        this.type = type;
    }

    /**
     * Gets blocks with which gate is built
     *
     * @return List<Block>
     */
    public List<Block> getBlocks() {
        if (blocks == null) blocks = new ArrayList<Block>();
        return blocks;
    }

    /**
     * Sets blocks with which gate is build
     *
     * @param blocks list of blocks
     */
    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }

    /**
     * Gets core block for gate
     *
     * @return Block
     */
    public Block getCore() {
        return core;
    }

    /**
     * Sets core block for gate
     *
     * @param core new core block
     */
    public void setCore(Block core) {
        this.core = core;
    }

    /**
     * Gets amount of blocks in X
     *
     * @return int
     */
    public int getX() {
        return x;
    }

    /**
     * Sets amount of blocks in X
     *
     * @param x new amount of blocks in X
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Gets amount of blocks in Y
     *
     * @return int
     */
    public int getY() {
        return y;
    }

    /**
     * Sets amount of blocks in Y
     *
     * @param y new amount of blocks in Y
     */
    public void setY(int y) {
        this.y = y;
    }
}
