package com.jatti;

import com.jatti.achievements.missions.npc.NpcClick;
import com.jatti.achievements.missions.npc.Spawn;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main plugin's class
 *
 * @author Jatti
 * @version 1.1
 */
public class LostGalaxy extends JavaPlugin {

    private static LostGalaxy inst;

    public static LostGalaxy getInst() {
        return inst;
    }

    @Override
    public void onEnable() {
        inst = this;
        Recipes.register();
        Bukkit.getPluginManager().registerEvents(new NpcClick(), this);
        getCommand("spawnnpc").setExecutor(new Spawn());
    }

    @Override
    public void onDisable() {
        inst = null;
    }

}
