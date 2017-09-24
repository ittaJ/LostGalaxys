package com.jatti.camera;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.jatti.computer.Computer;
import com.jatti.user.User;

public class CameraTeleportEvent extends Event{

	private static HandlerList handlers = new HandlerList();
	private User user;
	private Camera camera;
	private Computer computer;
	
	public CameraTeleportEvent(User user, Camera camera, Computer computer){
		this.user = user;
		this.camera = camera;
		this.computer = computer;
	}
	
	public Computer getComputer(){
		return computer;
	}
	
	public User getUser(){
		return user;
	}
	
	public Camera getCamera(){
		return camera;
	}
	
	
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList(){
		return handlers;
	}
}
