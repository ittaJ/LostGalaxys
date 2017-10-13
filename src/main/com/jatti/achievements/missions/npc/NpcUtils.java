package com.jatti.achievements.missions.npc;

import com.jatti.achievements.missions.Mission;
import com.jatti.achievements.missions.TestMission;

import java.util.ArrayList;
import java.util.List;

public class NpcUtils {

    private static List<Npc> npcs = new ArrayList<Npc>();


    public static List<Npc> getNpcs(){
        if(npcs == null) npcs = new ArrayList<Npc>();
        return npcs;
    }

    public static void addNpc(Npc npc){
        if(!npcs.contains(npc)) npcs.add(npc);
    }

}
