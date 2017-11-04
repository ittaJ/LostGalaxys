package com.jatti;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.List;
import java.util.UUID;

public class ItemBuilder {

    private ItemStack item = new ItemStack(Material.AIR, 1);
    private ItemMeta itemMeta = item.getItemMeta();

    public ItemBuilder() {
    }

    public ItemBuilder(ItemStack base) {
        this.item = base;
        this.itemMeta = base.getItemMeta();
    }

    public static ItemBuilder fromScratch() {
        return new ItemBuilder();
    }

    public static ItemBuilder fromItemStack(ItemStack base) {
        return new ItemBuilder(base);
    }

    public ItemStack build() {
        this.item.setItemMeta(this.itemMeta);
        return this.item;
    }

    public ItemBuilder type(Material type) {
        this.item.setType(type);
        return this;
    }

    public ItemBuilder amount(int amount) {
        this.item.setAmount(amount);
        return this;
    }

    public ItemBuilder durability(short durability) {
        this.item.setDurability(durability);
        return this;
    }

    public ItemBuilder name(String name) {
        this.itemMeta.setDisplayName(name);
        return this;
    }

    public ItemBuilder lore(List<String> lore) {
        this.itemMeta.setLore(lore);
        return this;
    }

    public ItemBuilder enchant(Enchantment ench, int lvl) {
        this.itemMeta.addEnchant(ench, lvl, true);
        return this;
    }

    public ItemBuilder unbreakable(boolean is) {
        this.itemMeta.setUnbreakable(is);
        return this;
    }

    public ItemBuilder flag(ItemFlag flag) {
        if (this.itemMeta.hasItemFlag(flag)) {
            this.itemMeta.removeItemFlags(flag);
        } else {
            this.itemMeta.addItemFlags(flag);
        }

        return this;
    }

    public ItemBuilder color(Color color) {
        if (this.itemMeta instanceof LeatherArmorMeta) {
            ((LeatherArmorMeta) this.itemMeta).setColor(color);
        }

        return this;
    }

    public ItemBuilder skullOwner(UUID skullOwner) {
        if (this.itemMeta instanceof SkullMeta) {
            ((SkullMeta) this.itemMeta).setOwningPlayer(Bukkit.getOfflinePlayer(skullOwner));
        }

        return this;
    }
}