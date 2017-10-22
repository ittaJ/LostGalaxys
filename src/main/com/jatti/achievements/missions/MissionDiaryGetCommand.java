package com.jatti.achievements.missions;

import com.jatti.user.User;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Command which gives missions diary to player
 */
public class MissionDiaryGetCommand implements CommandExecutor{

    public boolean onCommand(CommandSender snd, Command cmd, String l, String[] args){

        if(cmd.getName().equalsIgnoreCase("dziennik")){

            if(snd instanceof Player){

                Player p = (Player) snd;

                for(ItemStack is : p.getInventory().getStorageContents()){

                    if(is.hasItemMeta()){

                        if(is.getItemMeta().getDisplayName().contains("Dziennik Misji")){

                            p.getInventory().remove(is);
                            MissionDiary.showMissions(User.get(p.getName()));

                        }

                    }

                }

            }

        }

        return true;
    }
}
