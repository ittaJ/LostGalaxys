package com.jatti.camera;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Instrument;
import org.bukkit.Note;
import org.bukkit.Note.Tone;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.jatti.LostGalaxy;

import net.minecraft.server.v1_12_R1.PacketPlayOutCamera;

public class CameraTeleport implements Listener{
	
	
	@EventHandler
	public void onTeleport(final CameraTeleportEvent evt){
		
		evt.getUser().getPlayer().closeInventory();
		
		evt.getUser().sendMessage(ChatColor.DARK_GREEN + "Przeteleportowano do: " + ChatColor.GOLD + evt.getCamera().getValue());
		evt.getComputer().setEnergy(evt.getComputer().getEnergy()-2);
        evt.getUser().sendActionBar(3, 5, 3, ChatColor.DARK_RED + "-2 energii");
        
        
        evt.getUser().getPlayer().setGameMode(GameMode.SURVIVAL);

        evt.getUser().getPlayer().playSound(evt.getUser().getPlayer().getLocation(), Sound.BLOCK_CLOTH_BREAK, 1F, 2F);
        
        PacketPlayOutCamera pc = new PacketPlayOutCamera(evt.getCamera().getArmorStand().getHandle());
        evt.getUser().getCraftPlayer().getHandle().playerConnection.sendPacket(pc);
		
        Bukkit.getScheduler().runTaskLater(LostGalaxy.getInst(), 
				new Runnable(){
        	public void run(){
        		PacketPlayOutCamera pcc = new PacketPlayOutCamera(evt.getUser().getCraftPlayer().getHandle());
        		evt.getUser().getCraftPlayer().getHandle().playerConnection.sendPacket(pcc);
        		evt.getUser().getPlayer().playNote(evt.getUser().getPlayer().getLocation(), Instrument.XYLOPHONE, Note.natural(1, Tone.D));
        	}
        }, 10*20);
	}

}
