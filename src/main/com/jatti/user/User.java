package com.jatti.user;

import com.jatti.achievements.Archievement;
import net.minecraft.server.v1_12_R1.IChatBaseComponent;
import net.minecraft.server.v1_12_R1.PacketPlayOutTitle;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import com.jatti.camera.Camera;

import java.util.List;

public class User {

    private String name;
    private int money;
    private Camera clicked;
    private boolean isClicked;
    private boolean hasComputer;
    private boolean isChangingName;
    private int level;
    private double exp;
    private List<Archievement> archievements;

    public User(String name){

        this.name = name;

        UserUtils.addUser(this);
    }

    public static User get(String name){

        for(User u : UserUtils.getUsers()){

            if(u.getName().equals(name)) return u;

        }

        return new User(name);

    }

    public boolean isClicked(){ return isClicked; }

    public void setIsClicked(boolean isClicked){ this.isClicked = isClicked; }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) { this.money = money; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Camera getClicked() {
        return clicked;
    }

    public void setClicked(Camera clicked) {
        this.clicked = clicked;
    }
    
    public void sendMessage(String message){
    	
    	getPlayer().sendMessage(message);
    	
    }

    public void sendOneColorMessage(ChatColor color, String message){
        getPlayer().sendMessage(color + message);
    }

    public void sendActionBar(int fadein, int stay, int fadeout, String message){

        IChatBaseComponent ic = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + message + "\"}");
        PacketPlayOutTitle pc = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.ACTIONBAR, ic, fadein, stay, fadeout);

        ((CraftPlayer) Bukkit.getPlayer(name)).getHandle().playerConnection.sendPacket(pc);

    }

    public Player getPlayer(){
        return Bukkit.getPlayer(name);
    }
    
    public CraftPlayer getCraftPlayer(){
    	return (CraftPlayer)getPlayer();
    }

    public boolean isHasComputer() {
        return hasComputer;
    }

    public void setHasComputer(boolean hasComputer) {
        this.hasComputer = hasComputer;
    }

    public boolean isChangingName() {
        return isChangingName;
    }

    public void setChangingName(boolean changingName) {
        isChangingName = changingName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getExp() {
        return exp;
    }

    public void setExp(double exp) {
        this.exp = exp;
    }

    public void checkIfNextLevel(){

    }

    public List<Archievement> getArchievements() {
        return archievements;
    }

    public void setArchievements(List<Archievement> archievements) {
        this.archievements = archievements;
    }
}
