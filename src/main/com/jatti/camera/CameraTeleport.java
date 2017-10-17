package com.jatti.camera;

import com.jatti.LostGalaxy;
import net.minecraft.server.v1_12_R1.PacketPlayOutCamera;
import org.bukkit.*;
import org.bukkit.Note.Tone;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 * Listener when player teleports via camera
 * @author Jatti
 * @version 1.0
 */
public class CameraTeleport implements Listener {


    @EventHandler
    public void onTeleport(final CameraTeleportEvent evt) {

        evt.getUser().getPlayer().closeInventory();

        evt.getUser().sendMessage(ChatColor.DARK_GREEN + "Przeteleportowano do: " + ChatColor.GOLD + evt.getCamera().getValue());
        evt.getComputer().removeEnergy(evt.getUser(), 2);


        evt.getUser().getPlayer().setGameMode(GameMode.SURVIVAL);

        evt.getUser().getPlayer().playSound(evt.getUser().getPlayer().getLocation(), Sound.BLOCK_CLOTH_BREAK, 1F, 2F);

        PacketPlayOutCamera pc = new PacketPlayOutCamera(evt.getCamera().getArmorStand().getHandle());
        ((CraftPlayer)evt.getUser().getPlayer()).getHandle().playerConnection.sendPacket(pc);

        Bukkit.getScheduler().runTaskLater(LostGalaxy.getInst(),
                new Runnable() {
                    public void run() {
                        PacketPlayOutCamera pcc = new PacketPlayOutCamera(((CraftPlayer)evt.getUser().getPlayer()).getHandle());
                        ((CraftPlayer)evt.getUser().getPlayer()).getHandle().playerConnection.sendPacket(pcc);
                        evt.getUser().getPlayer().playNote(evt.getUser().getPlayer().getLocation(), Instrument.XYLOPHONE, Note.natural(1, Tone.D));
                    }
                }, 10 * 20);
    }

}
