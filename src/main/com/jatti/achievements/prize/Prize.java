package com.jatti.achievements.prize;

import org.bukkit.inventory.ItemStack;

import java.util.List;

public class Prize {

    private int value;
    private boolean isForLevel;
    private boolean isForArchievement;
    private boolean isForChallange;
    private double xp;
    private int gold;
    private List<ItemStack> items;

    public Prize(int value){

        //TODO make it

    }


    public List<ItemStack> getItems() {
        return items;
    }

    public void setItems(List<ItemStack> items) {
        this.items = items;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public double getXp() {
        return xp;
    }

    public void setXp(double xp) {
        this.xp = xp;
    }

    public boolean isForChallange() {
        return isForChallange;
    }

    public void setForChallange(boolean forChallange) {
        isForChallange = forChallange;
    }

    public boolean isForArchievement() {
        return isForArchievement;
    }

    public void setForArchievement(boolean forArchievement) {
        isForArchievement = forArchievement;
    }

    public boolean isForLevel() {
        return isForLevel;
    }

    public void setForLevel(boolean forLevel) {
        isForLevel = forLevel;
    }
}
