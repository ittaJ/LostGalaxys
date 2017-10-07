package com.jatti.achievements.prize;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Prize {

    private int value;
    private double xp;
    private int gold;
    private List<ItemStack> items;

    public Prize(int value) {

        this.value = value;
        PrizeUtils.addPrize(this);

    }

    public static Prize get(int value) {

        for (Prize p : PrizeUtils.getPrizes()) {

            if (p.getValue() == value) return p;

        }

        return new Prize(value);

    }

    public List<ItemStack> getItems() {
        if (items == null) items = new ArrayList<ItemStack>();
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
