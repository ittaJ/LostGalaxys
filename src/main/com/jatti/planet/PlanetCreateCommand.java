package com.jatti.planet;

import com.jatti.user.User;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

/**
 * Command when player creates planet
 *
 * @author Jatti
 * @version 1.0
 */
public class PlanetCreateCommand {

    /**
     * Method for creating planets
     * @param snd command sender
     * @param args command's arguments
     */
    public void onCreate(CommandSender snd, String[] args) {

        User u = User.get(snd.getName());

        for(Planet p : PlanetUtils.getPlanets()){

            if(p.getOwner().equals(u)){

                u.sendMessage(ChatColor.DARK_RED + "Nie mozesz miec wiecej niz jedna planete!");
                return;
            }

            if(p.getName().equalsIgnoreCase(args[1])){

                u.sendMessage(ChatColor.DARK_RED + "Juz istnieje planeta o tej nazwie!");
                return;
            }

        }

        Planet p = Planet.get(args[1]);

        p.onCreate();


    }

}
