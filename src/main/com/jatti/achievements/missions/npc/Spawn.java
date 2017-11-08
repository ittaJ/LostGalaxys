package com.jatti.achievements.missions.npc;

import com.jatti.achievements.missions.Mission;
import com.jatti.achievements.missions.MissionsList;
import org.apache.commons.lang.math.NumberUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Command for creating npcs
 *
 * @author Jatti
 * @version 1.0
 */
public class Spawn implements CommandExecutor {

    public boolean onCommand(CommandSender snd, Command cmd, String l, String[] args) {

            Player p = (Player) snd;
            if (args.length == 1) {
                if (NumberUtils.isNumber(args[0])) {
                    int id = Integer.parseInt(args[0]);

                    for (Mission m : MissionsList.getAllNpcMissions()) {
                        if (m.getId() == id) {
                            Npc n = new Npc(id, p.getLocation());
                            n.spawn();
                            p.sendMessage(ChatColor.GREEN + "Stworzono NPC z misja o ID " + id);
                        } else {
                            p.sendMessage(ChatColor.RED + "Nie ma takiej misji!");
                        }
                    }
                } else {
                    p.sendMessage(ChatColor.RED + "Nie ma takiej misji!");
                }
            }
        return true;
    }
}