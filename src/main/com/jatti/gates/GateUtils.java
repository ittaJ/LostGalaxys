package com.jatti.gates;

import java.util.ArrayList;
import java.util.List;

/**
 * Utils for gates
 *
 * @author Jatti
 * @version 1.0
 */
public class GateUtils {

    private static List<GateLook> gateLooks = new ArrayList<GateLook>();
    private static List<Gate> gates = new ArrayList<Gate>();

    /**
     * Gets all gatelooks
     *
     * @return List<GateLook>
     * @see com.jatti.gates.GateLook
     */
    public static List<GateLook> getGateLooks() {
        if (gateLooks == null) gateLooks = new ArrayList<GateLook>();
        return gateLooks;
    }

    /**
     * Gets all gates
     *
     * @return List<Gate>
     * @see com.jatti.gates.Gate
     */
    public static List<Gate> getGates() {
        if (gates == null) gates = new ArrayList<Gate>();
        return gates;
    }

    /**
     * Adds gatelook to list with gatelooks
     *
     * @param look gatelook to add
     */
    public static void addGateLook(GateLook look) {
        if (!gateLooks.contains(look)) gateLooks.add(look);
    }

    /**
     * Adds new gate to list with gates
     *
     * @param gate to add
     */
    public static void addGate(Gate gate) {
        if (!gates.contains(gate)) gates.add(gate);
    }

}
