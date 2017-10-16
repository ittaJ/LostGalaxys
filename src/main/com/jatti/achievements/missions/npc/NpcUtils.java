package com.jatti.achievements.missions.npc;

import java.util.ArrayList;
import java.util.List;

/**
 * Utils for NPC
 * @author Jatti
 * @version 1.0
 */
public class NpcUtils {

    private static List<Npc> npcs = new ArrayList<Npc>();


    /**
     * Gets list of all npcs
     * @return List<Npc>
     */
    public static List<Npc> getNpcs() {
        if (npcs == null) npcs = new ArrayList<Npc>();
        return npcs;
    }

    /**
     * Adds npc to list if it doesn't have it
     * @param npc npc which will be added
     */
    public static void addNpc(Npc npc) {
        if (!npcs.contains(npc)) npcs.add(npc);
    }

}
