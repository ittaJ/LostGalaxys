package com.jatti.user;

import com.jatti.achievements.Achievement;
import com.jatti.camera.Camera;
import com.jatti.user.tutorial.TutorialEvent;
import net.minecraft.server.v1_12_R1.IChatBaseComponent;
import net.minecraft.server.v1_12_R1.PacketPlayOutTitle;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private int gold;
    private Camera clicked;
    private boolean isClicked;
    private boolean hasComputer;
    private boolean isChangingName;
    private int level;
    private double exp;
    private boolean isOnPlanet;
    private List<Achievement> achievements;
    private List<Integer> ids;

    public User(String name) {

        this.name = name;

        UserUtils.addUser(this);
    }

    public static User get(String name) {

        for (User u : UserUtils.getUsers()) {

            if (u.getName().equals(name)) return u;

        }

        return new User(name);

    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setIsClicked(boolean isClicked) {
        this.isClicked = isClicked;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

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

    public void sendMessage(String message) {

        getPlayer().sendMessage(message);
    }


    public void sendActionBar(int fadein, int stay, int fadeout, String message) {

        IChatBaseComponent ic = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + message + "\"}");
        PacketPlayOutTitle pc = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.ACTIONBAR, ic, fadein, stay, fadeout);

        ((CraftPlayer) Bukkit.getPlayer(name)).getHandle().playerConnection.sendPacket(pc);

    }

    public Player getPlayer() {
        return Bukkit.getPlayer(name);
    }

    public CraftPlayer getCraftPlayer() {
        return (CraftPlayer) getPlayer();
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

    public void checkIfNextLevel() {

        if (exp == 0) level = 0;
        if (exp == 2 * ((level + 1) + 4) && level < 8) {
            Bukkit.getPluginManager().callEvent(new LevelUpEvent(this, level, level + 1));
            level += 1;
        }
        if (exp == 2.5 * ((level + 1) + 5) && level < 18 && level > 8) {
            Bukkit.getPluginManager().callEvent(new LevelUpEvent(this, level, level + 1));
            level += 1;
        }
        if (exp == 3 * (level + 1) + 20 && level < 37 && level > 18) {
            Bukkit.getPluginManager().callEvent(new LevelUpEvent(this, level, level + 1));
            level += 1;
        }
        if (exp == 5 * (level + 1) + 3 && level < 41 && level > 37) {
            Bukkit.getPluginManager().callEvent(new LevelUpEvent(this, level, level + 1));
            level += 1;
        }
        if (exp == 2 * (6 * ((level + 1) * 2)) && level > 40) {
            Bukkit.getPluginManager().callEvent(new LevelUpEvent(this, level, level + 1));
            level += 1;
        }
    }

    public void addLevels(int levels){

        Bukkit.getPluginManager().callEvent(new LevelUpEvent(this, level, level+levels));
        this.level = level+levels;

    }

    public void addExp(double exp){

        this.exp = this.exp+exp;
        checkIfNextLevel();

    }

    public void addGold(int gold){
        this.gold = this.gold+gold;
    }

    public boolean isOnPlanet() {
        return isOnPlanet;
    }

    public void setOnPlanet(boolean onPlanet) {
        isOnPlanet = onPlanet;
    }

    public void showTutorial() {
        Bukkit.getPluginManager().callEvent(new TutorialEvent(this));
    }

    public List<Achievement> getAchievements() {
        if(achievements == null) achievements = new ArrayList<Achievement>();
        return achievements;
    }

    public void setAchievements(List<Achievement> achievements) {
        this.achievements = achievements;
    }

    public void addAchievement(Achievement achievement){
        if(!achievements.contains(achievement)) achievements.add(achievement);
        sendMessage(""+ ChatColor.GREEN + "Zdobyto osiagniecie " + achievement.getName() + " !");
    }


    public List<Integer> getMissionsID() {
        return ids;
    }

    public void setMissionsID(List<Integer> ids) {
        this.ids = ids;
    }

    public void addMissionID(Integer id){
        if(!ids.contains(id)) ids.add(id);
    }
}
