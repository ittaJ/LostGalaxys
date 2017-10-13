package com.jatti;

import com.jatti.achievements.missions.npc.NpcClick;
import com.jatti.achievements.missions.npc.Spawn;
import com.jatti.atmosphere.AtmosphereChange;
import com.jatti.camera.CameraGuiInteract;
import com.jatti.camera.CameraInteract;
import com.jatti.camera.CameraTeleport;
import com.jatti.computer.ComputerChangeName;
import com.jatti.computer.ComputerGuiInteract;
import com.jatti.computer.ComputerInteract;
import com.jatti.entity.EntityCreate;
import com.jatti.teleporter.TeleporterPlace;
import com.jatti.user.Join;
import com.jatti.user.LevelUp;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class LostGalaxy extends JavaPlugin {

    private static LostGalaxy inst;

    public static LostGalaxy getInst() {
        return inst;
    }

    @Override
    public void onEnable() {
        inst = this;
        Recipes.register();
        Bukkit.getPluginManager().registerEvents(new CameraInteract(), this);
        Bukkit.getPluginManager().registerEvents(new ComputerInteract(), this);
        Bukkit.getPluginManager().registerEvents(new ComputerGuiInteract(), this);
        Bukkit.getPluginManager().registerEvents(new CameraGuiInteract(), this);
        Bukkit.getPluginManager().registerEvents(new CameraTeleport(), this);
        Bukkit.getPluginManager().registerEvents(new ComputerChangeName(), this);
        Bukkit.getPluginManager().registerEvents(new AtmosphereChange(), this);
        Bukkit.getPluginManager().registerEvents(new LevelUp(), this);
        Bukkit.getPluginManager().registerEvents(new Join(), this);
        Bukkit.getPluginManager().registerEvents(new EntityCreate(), this);
        Bukkit.getPluginManager().registerEvents(new TeleporterPlace(), this);
        Bukkit.getPluginManager().registerEvents(new NpcClick(), this);
        getCommand("spawnnpc").setExecutor(new Spawn());
    }

    @Override
    public void onDisable() {
        inst = null;
    }

}
