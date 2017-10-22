package com.jatti.achievements;

import com.jatti.Gui;
import com.jatti.planet.Planet;
import com.jatti.user.User;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Commend for opening achievements gui
 * @author Jatti
 * @version 1.0
 */
public class AchievementOpenCommand implements CommandExecutor{

    public boolean onCommand(CommandSender snd, Command cmd, String l, String[] args){

        if(cmd.getName().equalsIgnoreCase("osiagniecia")){

            if(snd instanceof Player){

                Gui.openAchievementGui(User.get(snd.getName()));
            }

        }

        return true;
    }
}
