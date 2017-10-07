package com.jatti.computer;

import com.jatti.Gui;
import com.jatti.user.User;
import org.bukkit.*;
import org.bukkit.Note.Tone;
import org.bukkit.block.Skull;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class ComputerInteract implements Listener {

    @SuppressWarnings("deprecation")
    @EventHandler
    public void onPlace(BlockPlaceEvent evt) {

        if (evt.getBlockPlaced().getType().equals(Material.SKULL)) {
            Skull s = (Skull) evt.getBlockPlaced().getState();

            if (s.getOwner().equals("Servers")) {
                User u = User.get(evt.getPlayer().getName());
                if (!u.isHasComputer()) {

                    Computer c = Computer.get(u);
                    c.setWhere(evt.getBlockPlaced().getLocation());
                    c.setEnergy(60);
                    c.setName("Komputer");
                    u.setHasComputer(true);


                } else {

                    evt.getPlayer().sendMessage(ChatColor.DARK_RED + "Nie mozesz miec dwoch komputerow!");
                    evt.setCancelled(true);

                }

            }

        }

    }

    @SuppressWarnings("deprecation")
    @EventHandler
    public void onInteract(PlayerInteractEvent evt) {

        if (evt.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            User u = User.get(evt.getPlayer().getName());

            if (evt.getClickedBlock().getType().equals(Material.SKULL)) {

                Skull s = (Skull) evt.getClickedBlock().getState();


                if (s.getOwner().equals("Servers")) {

                    if (Computer.getFromLocation(evt.getClickedBlock().getLocation()).getOwner().equals(u)) {

                        Computer c = Computer.get(u);

                        if (u.isClicked()) {

                            if (c.getCameras().size() == 8) {

                                evt.getPlayer().sendMessage(ChatColor.DARK_RED + "Nie mozesz dodac juz wiecej kamer!");

                            } else {

                                c.getCameras().add(u.getClicked());

                                u.getClicked().setConnected(true);

                                u.setClicked(null);
                                u.setIsClicked(false);

                                evt.getPlayer().playNote(evt.getPlayer().getLocation(), Instrument.XYLOPHONE, Note.flat(1, Tone.E));
                                evt.getPlayer().spawnParticle(Particle.END_ROD, evt.getClickedBlock().getLocation(), 50);
                                evt.getPlayer().sendMessage(ChatColor.GREEN + "Dodano kamere do komputera!");

                                evt.getPlayer().closeInventory();

                            }

                        } else if (c.getEnergy() < 5) {

                            evt.getPlayer().sendMessage(ChatColor.DARK_RED + "Komputer nie moze byc wlaczony bez energii!");

                        } else if (c.getEnergy() > 5) {

                            c.setEnergy(c.getEnergy() - 2.5);
                            u.sendActionBar(3, 5, 3, ChatColor.DARK_RED + "-2.5 energii");
                            Gui.openComputerGui(u);

                        }

                    } else {

                        evt.getPlayer().sendMessage(ChatColor.DARK_RED + "Nie mozesz otworzyc czyjegos komputera!");

                    }

                }


            }
        }

    }

}
