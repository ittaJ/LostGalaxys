package com.jatti.computer;

import com.jatti.Gui;
import com.jatti.user.User;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ComputerGuiInteract implements Listener{


    @EventHandler
    public void onInvClick(InventoryClickEvent evt){

        if(evt.getWhoClicked() instanceof Player){

            User u = User.get(evt.getWhoClicked().getName());

            if(u.isHasComputer()){

                Computer c = Computer.get(u);

                if(evt.getInventory().getName().equals(c.getName())){

                    if(evt.getCurrentItem().getItemMeta().getDisplayName().contains("Wylacz")){

                        evt.getWhoClicked().closeInventory();
                        evt.getWhoClicked().sendMessage(ChatColor.DARK_GREEN + "Wylaczono komputer!");

                    }

                    if(evt.getCurrentItem().getItemMeta().getDisplayName().contains("Zmien Nazwe")){
                        c.setEnergy(c.getEnergy()-1);
                        u.sendActionBar(3, 5, 3, ChatColor.DARK_RED + "-1 energii");
                        evt.getWhoClicked().closeInventory();
                        evt.getWhoClicked().sendMessage(ChatColor.DARK_GREEN + "Zmien nazwe komputera (napisz na chacie)");
                        u.setChangingName(true);

                }

                    if(evt.getCurrentItem().getItemMeta().getDisplayName().contains("Kamery")){
                        c.setEnergy(c.getEnergy()-2);
                        u.sendActionBar(3, 5, 3, ChatColor.DARK_RED + "-2 energii");
                        evt.getWhoClicked().closeInventory();
                        Gui.openCamerasGui(u);

                    }

                    if(evt.getCurrentItem().getItemMeta().getDisplayName().contains("Dodaj energie")){

                        evt.getWhoClicked().closeInventory();
                        //Gui.openEnergyGui(u);

                }

                }

            }


        }

    }
}
