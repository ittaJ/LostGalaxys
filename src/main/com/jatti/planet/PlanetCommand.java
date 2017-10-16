package com.jatti.planet;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * All commands for planet
 *
 * @author Jatti
 * @version 1.0
 */
public class PlanetCommand implements CommandExecutor {

    public boolean onCommand(CommandSender snd, Command cmd, String l, String[] args) {

        if (cmd.getName().equalsIgnoreCase("p")) {

            if (args.length == 2){

                if (args[0].equalsIgnoreCase("stworz") || args[0].equalsIgnoreCase("create")) {
                    
                    new PlanetCreateCommand().onCreate(snd, args);

                }

            }

        }
        return true;

    }

}
