package com.jatti.atmosphere;

import com.jatti.planet.Planet;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class AtmosphereChangeEvent extends Event{
	
	private static HandlerList handlers = new HandlerList();
	private Planet planet;
	private Atmosphere oldAtmosphere;
	private Atmosphere newAtmosphere;
	private boolean canDestroy;
	private boolean willWork;
	private int changeTime;
	
	public AtmosphereChangeEvent(Planet planet, Atmosphere oldAtmosphere, Atmosphere newAtmosphere) {
		this.planet = planet;
		this.oldAtmosphere = oldAtmosphere;
		this.newAtmosphere = newAtmosphere;
		this.canDestroy = false;
		this.willWork = true;
		this.changeTime = 20;
		//TODO add random values to canDestroy (canDestroy can destroy your planet), willWork (if atmosphere change will works), changeTime (time which is needed to change atmosphere)
		
	}

	public Planet getPlanet() {
		return planet;
	}
	
	public Atmosphere getOldAtmosphere() {
		return oldAtmosphere;
	}
	
	public Atmosphere getNewAtmosphere() {
		return newAtmosphere;
	}
	
	public boolean canDestroy() {
		return this.canDestroy;
	}
	
	public boolean willWork() {
		return this.willWork;
	}
	
	public int getChangeTime() {
		return changeTime;
	}
	
	
	
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
	
	public static HandlerList getHandlerList() {
		return handlers;
	}

}
