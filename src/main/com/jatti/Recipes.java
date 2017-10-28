package com.jatti;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class for new recipes
 *
 * @author Jatti
 * @version 1.0
 */
class Recipes {

    private static List<ShapedRecipe> shapedRecipes = new ArrayList<ShapedRecipe>();
    private static List<ShapelessRecipe> shapelessRecipes = new ArrayList<ShapelessRecipe>();


    //TODO find better way to do it
    private static void addShaped() {

        ItemStack camera = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta cameraMeta = (SkullMeta) camera.getItemMeta();
        cameraMeta.setOwner("Wulfenrat");
        cameraMeta.setDisplayName(ChatColor.GRAY + "Kamera");
        cameraMeta.setLore(Arrays.asList(ChatColor.YELLOW + "Poloz jak blok, by dzialala musi byc podlaczona do komputera",
                ChatColor.YELLOW + "Do jednego komputera bez ulepszen mozna podlaczyc maksymalnie 9 kamer"));
        camera.setItemMeta(cameraMeta);


        ShapedRecipe cameraRecipe = new ShapedRecipe(camera);
        cameraRecipe.shape("&&&", "&*&", "&&&");
        cameraRecipe.setIngredient('&', Material.WOOL);
        cameraRecipe.setIngredient('*', Material.GLASS);

        shapedRecipes.add(cameraRecipe);

        ItemStack computer = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta computerMeta = (SkullMeta) computer.getItemMeta();
        computerMeta.setOwner("servers");
        computerMeta.setDisplayName(ChatColor.GRAY + "Komputer");
        computerMeta.setLore(Arrays.asList(ChatColor.YELLOW + "Poloz jak blok",
                ChatColor.YELLOW + "Do uzywania komputera potrzebna jest energia z " + ChatColor.DARK_AQUA + "Niebieskich Krysztalow"));
        computer.setItemMeta(computerMeta);

        ShapedRecipe computerRecipe = new ShapedRecipe(computer);
        computerRecipe.shape("&*&", "&-&", "&&&");
        computerRecipe.setIngredient('&', Material.IRON_BLOCK);
        computerRecipe.setIngredient('-', Material.REDSTONE_BLOCK);
        computerRecipe.setIngredient('*', Material.REDSTONE_LAMP_OFF);

        shapedRecipes.add(computerRecipe);

        ItemStack battery = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta batteryMeta = (SkullMeta) battery.getItemMeta();
        batteryMeta.setOwner("bman1661");
        batteryMeta.setDisplayName(ChatColor.GRAY + "Bateria");
        batteryMeta.setLore(Arrays.asList(ChatColor.YELLOW + "Poloz jak blok",
                ChatColor.YELLOW + "Slozy do zasilania innych rzeczy",
                ChatColor.YELLOW + "Czerpie energie z " + ChatColor.DARK_AQUA + "Bialych Krysztalow",
                ChatColor.YELLOW + "Mozna do niej podlaczyc wszystkie maszyny"));
        battery.setItemMeta(batteryMeta);

        ShapedRecipe batteryRecipe = new ShapedRecipe(battery);
        batteryRecipe.shape("***", "*&*", "***");
        batteryRecipe.setIngredient('*', Material.IRON_BLOCK);
        batteryRecipe.setIngredient('&', Material.REDSTONE_BLOCK);

        shapedRecipes.add(batteryRecipe);
    }

    private static void addShapeless() {

        //TODO White Crystals & Blue Crystals & Yellow Crystals & EnergyAddons

    }

    /**
     * Registers all recipes in main class
     */
    static void register() {

        addShaped();
        addShapeless();

        for (ShapedRecipe sh : shapedRecipes) {

            Bukkit.addRecipe(sh);

        }

        for (ShapelessRecipe ush : shapelessRecipes) {

            Bukkit.addRecipe(ush);

        }

    }
}
