package com.jatti.achievements.missions.npc;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spawn implements CommandExecutor{


    public boolean onCommand(CommandSender snd, Command cmd, String l, String[] args){

        if(cmd.getName().equalsIgnoreCase("spawnnpc")){

            if(args.length == 1){

                int id = Integer.parseInt(args[0]);

                Player p = (Player) snd;
                Npc n = new Npc(id, p.getLocation());

                n.spawn();
                p.sendMessage(ChatColor.GREEN + "Stworzono NPC z misja o ID " + id);
            }

        }

        return true;
    }
}
