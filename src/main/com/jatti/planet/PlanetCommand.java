package com.jatti.planet;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PlanetCommand implements CommandExecutor {

    public boolean onCommand(CommandSender snd, Command cmd, String l, String[] args) {

        if (cmd.getName().equalsIgnoreCase("p")) {

            if (args.length == 1) {

                if (args[0].equalsIgnoreCase("stworz") || args[0].equalsIgnoreCase("create")) {

                    //TODO done after rewriting User class

                }

            }

        }
        return true;

    }

}
