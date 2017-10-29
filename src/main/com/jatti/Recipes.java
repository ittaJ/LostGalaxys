package com.jatti;

import java.util.Arrays;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

/**
 * Shaped and shapeless recipe adding
 *
 * @author Jatti
 * @version 1.1
 */
public class Recipes {

    private static final ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);

    private static void addShaped() {
        ShapedRecipe cameraRecipe = new ShapedRecipe(new NamespacedKey(LostGalaxy.getPlugin(), "camera"), ItemBuilder
                        .fromItemStack(skull).name(ChatColor.GRAY + "Kamera")
                        .lore(Arrays.asList(ChatColor.YELLOW + "Poloz jak blok, by dzialala musi byc podlaczona do komputera",
                                        ChatColor.YELLOW + "Do jednego komputera bez ulepszen mozna podlaczyc maksymalnie 9 kamer"))
                        .skullOwner(UUID.fromString("58dc870e-c399-4cb3-badc-3dd30b2f1964")).build());
        
        cameraRecipe.shape("&&&", "&*&", "&&&");
        cameraRecipe.setIngredient('&', Material.WOOL);
        cameraRecipe.setIngredient('*', Material.GLASS);
        Bukkit.addRecipe(cameraRecipe);

        ShapedRecipe computerRecipe = new ShapedRecipe(new NamespacedKey(LostGalaxy.getPlugin(), "computer"), ItemBuilder
                        .fromItemStack(skull).name(ChatColor.GRAY + "Komputer")
                        .lore(Arrays.asList(ChatColor.YELLOW + "Poloz jak blok", ChatColor.YELLOW + "Do uzywania komputera potrzebna jest energia z "
                                        + ChatColor.DARK_AQUA + "Niebieskich Krysztalow"))
                        .skullOwner(UUID.fromString("fb392c3e-3580-4635-9974-886a8ef716a7")).build());
        
        computerRecipe.shape("&*&", "&-&", "&&&");
        computerRecipe.setIngredient('&', Material.IRON_BLOCK);
        computerRecipe.setIngredient('-', Material.REDSTONE_BLOCK);
        computerRecipe.setIngredient('*', Material.REDSTONE_LAMP_OFF);
        Bukkit.addRecipe(computerRecipe);

        ShapedRecipe batteryRecipe = new ShapedRecipe(new NamespacedKey(LostGalaxy.getPlugin(), "battery"), ItemBuilder
                        .fromItemStack(skull).name(ChatColor.GRAY + "Bateria")
                        .lore(Arrays.asList(ChatColor.YELLOW + "Poloz jak blok", ChatColor.YELLOW + "Sluzy do zasilania innych rzeczy",
                                        ChatColor.YELLOW + "Czerpie energie z " + ChatColor.DARK_AQUA + "Bialych Krysztalow",
                                        ChatColor.YELLOW + "Mozna do niej podlaczyc wszystkie maszyny"))
                        .skullOwner(UUID.fromString("ad1a8a4a-3789-4a00-ae5f-907c411f40c3")).build());
        batteryRecipe.shape("***", "*&*", "***");
        batteryRecipe.setIngredient('*', Material.IRON_BLOCK);
        batteryRecipe.setIngredient('&', Material.REDSTONE_BLOCK);

        Bukkit.addRecipe(batteryRecipe);
    }

    private static void addShapeless() {
        // TODO White Crystals & Blue Crystals & Yellow Crystals & EnergyAddons
    }

    public static void add() {
        addShaped();
        addShapeless();
    }
}
