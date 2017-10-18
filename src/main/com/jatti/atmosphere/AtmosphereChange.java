package com.jatti.atmosphere;


import com.jatti.LostGalaxy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 * Listener when atmosphere starts to change
 * @author Jatti
 * @version 1.1
 */
public class AtmosphereChange implements Listener {


    @EventHandler
    public void onChange(final AtmosphereChangeEvent evt) {

        //TODO make better atmosphere change

        if(evt.willWork()){

            if(evt.canDestroy()){

                //TODO Make chance to destroy

            }else{

                evt.getPlanet().getOwner().sendMessage(ChatColor.DARK_GREEN + "Zmiana atmosfery rozpoczela sie zakonczy sie za " + ChatColor.GOLD + evt.getChangeTime() + "s");
                Bukkit.getScheduler().runTaskLater(LostGalaxy.getInst(),
                        new Runnable() {
                            public void run() {

                                //TODO effects like particles or sounds or something :/
                                evt.getPlanet().setAtmosphere(evt.getNewAtmosphere());
                                evt.getPlanet().getOwner().sendMessage(ChatColor.DARK_GREEN + "Zmieniono atmosfere z " + ChatColor.GOLD + evt.getOldAtmosphere().getName() + ChatColor.DARK_GREEN + " na " + ChatColor.GOLD + evt.getNewAtmosphere().getName());

                            }
                        }, evt.getChangeTime());

            }

        }else{
            evt.getPlanet().getOwner().sendMessage(ChatColor.DARK_RED + "Nie mozesz zmienic atmosfery na ta!");
        }

    }
}
