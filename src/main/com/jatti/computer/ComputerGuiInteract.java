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
                        c.removeEnergy(u, 1);
                        evt.getWhoClicked().closeInventory();
                        evt.getWhoClicked().sendMessage(ChatColor.DARK_GREEN + "Zmien nazwe komputera (napisz na chacie)");
                        u.setChangingName(true);

                }

                    if(evt.getCurrentItem().getItemMeta().getDisplayName().contains("Kamery")){
                        c.removeEnergy(u, 2);
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
