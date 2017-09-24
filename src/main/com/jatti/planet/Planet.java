package com.jatti.planet;

import com.jatti.atmosphere.Atmosphere;
import com.jatti.atmosphere.AtmosphereChangeEvent;
import com.jatti.user.User;
import org.bukkit.Bukkit;

public class Planet {

	private String name;
	private Atmosphere atmosphere;
	private User owner;
	//TODO make it working
	
	public Planet(String name) {
		this.name = name;
	}


	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public User getOwner() {
		return owner;
	}
	
	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Atmosphere getAtmosphere(){
	    return atmosphere;
    }

    public void setAtmosphere(Atmosphere atmosphere){
	    this.atmosphere = atmosphere;
    }

	public void changeAtmosphere(Atmosphere newAtmosphere) {
		Bukkit.getPluginManager().callEvent(new AtmosphereChangeEvent(this, atmosphere, newAtmosphere));
	}
	
}
