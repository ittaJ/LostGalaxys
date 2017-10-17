package com.jatti.camera;

import com.jatti.computer.Computer;
import com.jatti.user.User;
import org.bukkit.ChatColor;
import org.bukkit.Instrument;
import org.bukkit.Material;
import org.bukkit.Note;
import org.bukkit.Note.Tone;
import org.bukkit.block.Skull;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftArmorStand;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashMap;

/**
 * Listener when you place camera on ground or when you click on it
 * @author Jatti
 * @version 1.0
 */
public class CameraInteract implements Listener {

    public static HashMap<User, Camera> isClicked = new HashMap<User, Camera>();

    @SuppressWarnings("deprecation")
    @EventHandler
    public void onPlace(BlockPlaceEvent evt) {

        if (evt.getBlockPlaced().getType().equals(Material.SKULL)) {

            Skull s = (Skull) evt.getBlockPlaced().getState();

            if (s.getOwner().equals("Wulfenrat")) {

                User u = User.get(evt.getPlayer().getName());


                if (!u.getHasComputer()) {

                    evt.getPlayer().sendMessage(ChatColor.DARK_RED + "Nie mozesz postawic kamery jesli nie masz komputera!");
                    evt.setCancelled(true);


                } else {
                    Computer c = Computer.get(u);

                    if (c.getCameras().size() == 8) {

                        evt.getPlayer().sendMessage(ChatColor.DARK_RED + "Masz juz maksymalna liczbe kamer!");
                        evt.setCancelled(true);

                    } else {

                        Camera camera = Camera.Companion.get(u, c.getCameras().size() + 1);
                        camera.setConnected(false);
                        camera.setWhere(evt.getBlockPlaced().getLocation());
                        ArmorStand as = evt.getBlockPlaced().getWorld().spawn(evt.getBlockPlaced().getLocation(), ArmorStand.class);
                        as.setVisible(false);
                        as.setAI(false);
                        camera.setArmorStand((CraftArmorStand) as);
                    }
                }


            }
        }

    }

    @SuppressWarnings("deprecation")
    @EventHandler
    public void onInteract(PlayerInteractEvent evt) {

        if (evt.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {

            if (evt.getClickedBlock().getType().equals(Material.SKULL)) {

                Skull s = (Skull) evt.getClickedBlock().getState();

                if (s.getOwner().equals("Wulfenrat")) {

                    for (Camera c : CameraUtils.getCamerasForUser(User.get(evt.getPlayer().getName()))) {

                        if (c.getWhere().equals(evt.getClickedBlock().getLocation())) {

                            if (!c.isConnected()) {
                                User u = User.get(evt.getPlayer().getName());

                                isClicked.put(u, c);
                                evt.getPlayer().sendMessage(ChatColor.GOLD + "Polacz ta kamere z komputerem, by moc jej uzywac!");
                                u.getPlayer().playNote(u.getPlayer().getLocation(), Instrument.XYLOPHONE, Note.flat(1, Tone.B));

                            } else {

                                evt.getPlayer().playNote(evt.getPlayer().getLocation(), Instrument.XYLOPHONE, Note.flat(1, Tone.C));
                                evt.getPlayer().sendMessage(ChatColor.GOLD + "Rozlaczyles kamere!");
                                c.setConnected(false);

                            }
                        }

                    }

                }

            }
        }
    }

}
