package com.jatti;

import com.jatti.atmosphere.AtmosphereChange;
import com.jatti.camera.CameraGuiInteract;
import com.jatti.camera.CameraInteract;
import com.jatti.camera.CameraTeleport;
import com.jatti.computer.ComputerChangeName;
import com.jatti.computer.ComputerGuiInteract;
import com.jatti.computer.ComputerInteract;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class LostGalaxy extends JavaPlugin {

    private static LostGalaxy inst;


    @Override
    public void onEnable(){
        inst = this;
        Recipes.register();
        Bukkit.getPluginManager().registerEvents(new CameraInteract(), this);
        Bukkit.getPluginManager().registerEvents(new ComputerInteract(), this);
        Bukkit.getPluginManager().registerEvents(new ComputerGuiInteract(), this);
        Bukkit.getPluginManager().registerEvents(new CameraGuiInteract(), this);
        Bukkit.getPluginManager().registerEvents(new CameraTeleport(), this);
        Bukkit.getPluginManager().registerEvents(new ComputerChangeName(), this);
        Bukkit.getPluginManager().registerEvents(new AtmosphereChange(), this);
    }


    @Override
    public void onDisable(){
        inst = null;
    }

    public static LostGalaxy getInst(){
        return inst;
    }

}
