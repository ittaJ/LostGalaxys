package com.jatti.planet;

import com.jatti.user.User;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlanetCreateCommand {

    public void onCreate(CommandSender snd){

        User u = User.get(snd.getName());

        //TODO make command after rewriting User class

    }

}
