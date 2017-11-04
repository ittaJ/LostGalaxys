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

    private static LostGalaxy plugin;

    public LostGalaxy() {
        plugin = this;
    }

    public static LostGalaxy getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        Recipes.add();

        Bukkit.getPluginManager().registerEvents(new NpcClick(), this);

        getCommand("spawnnpc").setExecutor(new Spawn());
    }

    @Override
    public void onDisable() {
        plugin = null;
    }
}
