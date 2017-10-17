package com.jatti.camera;

import com.jatti.computer.Computer;
import com.jatti.user.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * Listener when player clicks in camera's gui
 * @author Jatti
 * @version 1.0
 */
public class CameraGuiInteract implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent evt) {

        if (evt.getWhoClicked() instanceof Player) {

            if (evt.getInventory().getName().contains("Kamery")) {

                User u = User.get(evt.getWhoClicked().getName());
                Computer comp = Computer.get(u);
                for (Camera c : comp.getCameras()) {

                    if (evt.getCurrentItem().getItemMeta().getDisplayName().contains("" + c.getValue())) {

                        Bukkit.getPluginManager().callEvent(new CameraTeleportEvent(u, c, comp));

                    }

                }

            }
        }
    }

}
